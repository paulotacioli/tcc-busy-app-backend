package com.busy.apis.service;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.busy.apis.entities.Destino;
import com.busy.apis.entities.Order;
import com.busy.apis.entities.Taxa;
import com.busy.apis.entities.TipoServico;
import com.busy.apis.entities.Usuario;
import com.busy.apis.entities.matrix.MatrixDistanciaGoogle;
import com.busy.apis.entities.matrix.MenorCaminhoRequest;
import com.busy.apis.repositories.DestinoRepository;
import com.busy.apis.repositories.IdentifierRepository;
import com.busy.apis.repositories.OrderRepository;
import com.busy.apis.repositories.TaxaRepository;
import com.busy.apis.repositories.TipoServicoRepository;
import com.busy.apis.repositories.UsuarioRepository;
import com.busy.apis.service.exceptions.CamposObrigatoriosException;
import com.busy.apis.service.exceptions.ErroNaoMapeadoException;
import com.busy.apis.service.exceptions.OrderAlocadoException;
import com.busy.apis.service.exceptions.RecursoNaoEncontradoException;
import com.busy.apis.service.exceptions.ReferenciaExternaException;
import com.busy.apis.service.exceptions.TamanhoMaximoException;
import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.RateLimitException;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	@Autowired
	private DestinoRepository destinoRepository;
	@Autowired
	private TipoServicoRepository tipoServicoRepository;
	@Autowired
	private TaxaRepository taxaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private IdentifierRepository identifierRepository;
	@Autowired
	private PaymentService paymentService;
	
	public List<Order> findAll() {
		return repository.findAll();

	}
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id,1));
	}
	
	public List<Order> findAllByUsuario(Long cpf) {
		Usuario usuario = new Usuario();
		usuario.setCpf(cpf);
		
		return repository.findAllByUsuario(usuario);

	}
	
	
	
	public PaymentIntent confirmarPagamento (String idPagamento) {
		Stripe.apiKey = "sk_test_51LNlGMDhqqUuyiSLhj6vNyuWFODkVlTUsE0JbBDTWogIEdX0my43Rlp1qIsMhT1tNoCb9XIRzbz82A0aniNuFiCJ00wettmT3S";

		try {

			// To create a PaymentIntent for confirmation, see our guide at: https://stripe.com/docs/payments/payment-intents/creating-payment-intents#creating-for-automatic
			PaymentIntent paymentIntent =
			  PaymentIntent.retrieve(
					  idPagamento
			  );

			Map<String, Object> params = new HashMap<>();
			params.put("payment_method", "pm_card_visa");

			PaymentIntent updatedPaymentIntent =
			  paymentIntent.confirm(params);
			} catch (CardException e) {
			  // Since it's a decline, CardException will be caught
			  System.out.println("Status is: " + e.getCode());
			  System.out.println("Message is: " + e.getMessage());
			} catch (RateLimitException e) {
			  // Too many requests made to the API too quickly
			} catch (InvalidRequestException e) {
			  // Invalid parameters were supplied to Stripe's API
			} catch (AuthenticationException e) {
			  // Authentication with Stripe's API failed
			  // (maybe you changed API keys recently)
			
			} catch (StripeException e) {
			  // Display a very generic error to the user, and maybe send
			  // yourself an email
			} catch (Exception e) {
			  // Something else happened, completely unrelated to Stripe
			}
		return null;
	}
	
	public double[] calcularPrecoServico(Order objOrderInput) {
		double precoTotal = 0;
        NumberFormat nf= NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
		List<Destino> obj = objOrderInput.getDestino();

		double distanciaCalculada = objOrderInput.getDistanciaCalculada();
		double[] resultado = new double[4];

		for (int i = 0; i < obj.size(); i++) {

			TipoServico objTipoServico = new TipoServico();
			


			if (obj.get(i).getTipoAtividadeRetiradaPrestacao().equals("Retirar um Item")) {

				objTipoServico = tipoServicoRepository.findByTipoServico("Retirar um Item");

				precoTotal = precoTotal + objTipoServico.getPreco();

			} else {

				objTipoServico = tipoServicoRepository.findByTipoServico(obj.get(i).getTipoServicoPrestacao());

				precoTotal = precoTotal + objTipoServico.getPreco();
				
			

			}
			

		}
		
		/* Soma o preço por kilometro rodado*/
		Taxa objTaxaKm = new Taxa();
		objTaxaKm = taxaRepository.findByEntidade("Preco por Km");
		precoTotal = Precision.round(precoTotal + (objTaxaKm.getTaxa() * distanciaCalculada),2);
		
		
		
		/*Calcula a porcentagem da BUSY em cima do preço do serviço e preço por kilometragem*/
		Taxa objTaxaBusy = new Taxa();
		objTaxaBusy = taxaRepository.findByEntidade("Busy");
		double porcentagemBusy = objTaxaBusy.getTaxa();
		double precoParticipacaoBusy = Precision.round(porcentagemBusy*precoTotal/100,2);
		precoTotal = Precision.round(precoTotal + precoParticipacaoBusy,2);
		
		resultado[0]=Precision.round(precoTotal, 2);
		resultado[1]=objTaxaBusy.getTaxa();
		resultado[2]=Precision.round(precoParticipacaoBusy,2);
		resultado[3]=objTaxaKm.getTaxa();

		
	

		return resultado;
		
	}
	

	public Double calcularDistancia(List<Destino> obj) {
		try {
			int total = 0;
			String origem = "";
				System.out.println(obj.toString());
			for (int i = 0; i < obj.size(); i++) {
				if(i == 0) {
			
					origem= origem + obj.get(i).getDestino()+"|";

				} else if (i == obj.size()-1) {
					origem= origem + obj.get(i).getDestino();
					
				} else {

					origem= origem + obj.get(i).getDestino()+"|";

				}
			}
			System.out.println(origem);
			
			String urlFinal = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins="+origem+"&destinations="+origem+"&key=AIzaSyBkfegG3FRQoNtgKbIJNKkkv02DgmTGXt0";	
			OkHttpClient client = new OkHttpClient().newBuilder()
					  .build();
					Request request = new Request.Builder()
					.url(urlFinal)

					  //.url("https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=RUA LUIS G�IS, 1787 - MIRAND�POLIS, S�O PAULO CEP:04043500|RUA IBIUNA, 352 - BOSQUE DOS EUCALIPTOS, S�O JOS� DOS CAMPOS CEP:12233500|R. Ol�vio Vi�ira da Rosa, 180 - Jardim Santa Maria jacarei  CEP:12328-100&destinations=RUA LUIS G�IS, 1787 - MIRAND�POLIS, S�O PAULO CEP:04043500|RUA IBIUNA, 352 - BOSQUE DOS EUCALIPTOS, S�O JOS� DOS CAMPOS CEP:12233500|R. Ol�vio Vi�ira da Rosa, 180 - Jardim Santa Maria jacarei  CEP:12328-100&key=AIzaSyDMXEvPsNDfZbDXlP7K0kug3Eh6KdXIPEE")
					  .method("GET", null)
					  .build();
					Response response2 = client.newCall(request).execute();
					
					String response = response2.body().string();

					MatrixDistanciaGoogle matrixDistanciaResponse = null;

					Gson gson = new Gson();
					String jsonString = gson.toJson(response);
					System.out.println(jsonString);
					matrixDistanciaResponse = gson.fromJson(response.toString(), MatrixDistanciaGoogle.class);

					if (matrixDistanciaResponse.getStatus().equalsIgnoreCase("MAX_ELEMENTS_EXCEEDED")) {
						throw new TamanhoMaximoException();
						
					}
					

			//conn.disconnect();
			long[][] adj = new long[matrixDistanciaResponse.getRows().size()][matrixDistanciaResponse.getRows().size()];

			int tamanho = matrixDistanciaResponse.getRows().size();
			for (int i = 0; i < tamanho; i++) {
				for (int j = 0; j < tamanho; j++) {
					
								adj[i][j] = matrixDistanciaResponse.getRows().get(i).getElements()[j].getDistance().getValue();

				}
			}

//			for (int i = 0; i < tamanho; i++) {
//
//				for (int j = 0; j < tamanho; j++) {
//
//					System.out.println("distancia"+ adj[j][i]);
//				}
//			}
			double distanciaCalculada = 0;
			for (int i = 0; i < obj.size()-1; i++) {

				distanciaCalculada = distanciaCalculada + adj[i][i+1];
				
			}
			System.out.println("distancia Calculada final: "+ distanciaCalculada );

			
		
			return distanciaCalculada;

			
		} catch (IOException e) {
			// Logger.getLogger(APIRest.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (double) 0;
		
	}


	public Order insert(Order obj) {
		try {
			List<Destino> objDestino = new ArrayList<Destino>();
			MenorCaminhoRequest enderecos = new MenorCaminhoRequest();
			objDestino = obj.getDestino();
			
			

		
			
			/*Calcular a distancia entre todos os pontos*/
			double distanciaCalculada = calcularDistancia(objDestino)/1000;
			obj.setDistanciaCalculada(distanciaCalculada);

			double[] resultado = calcularPrecoServico(obj);

			/*Calcular a distancia o preço do serviço*/
			obj.setPrecoServico(resultado[0]);
			obj.setCotacaoBusy(resultado[1]);
			obj.setPrecoBusy(resultado[2]);
			obj.setCotacaoKm(resultado[3]);

			/*Seta o status como Procurando Alocacao*/
			obj.setStatus("Criado");
			

			Order objOrder = repository.save(obj);

			for (Destino objAtual : objDestino) {
				Order objOrderId = new Order();
				objOrderId.setId(objOrder.getId());
				objAtual.setOrder(objOrderId);
				destinoRepository.save(objAtual);


			}

			return obj;
		
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			String erro  = "Erro de referência externa. ";
			throw new ReferenciaExternaException(erro);

		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			throw new CamposObrigatoriosException(null,"Campos obrigatórios devem ser preenchidos.");
			
		} catch (RuntimeException e) {

			e.printStackTrace();
			throw new ErroNaoMapeadoException("");
		}

	}
	
	public Order procurarAlocacao (Order obj) {
		Optional<Order> objOrder = repository.findById(obj.getId());

		try {
			if (objOrder.get().getStatus().equals("Criado")) {
				objOrder.get().setDataProcurandoAlocacao(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
				

				/* Essa função deve receber o pagamento no valor de x
				 */
			
				paymentService.criarPagamento(objOrder.get(), obj.getCard());

			objOrder.get().setStatus("Procurando Alocação");
			/* Essa função deve notificar os motoristas que estão 
			 * próximos do endereço obj.getDestinos().get(0).getDestino()
			 */
			repository.save(objOrder.get());
			} else {
				throw new OrderAlocadoException("Esse pedido não esta na posição correta da esteira para executar essa movimentação!");

			}
			return obj;
		
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			String erro  = "Erro de referência externa. ";
			throw new ReferenciaExternaException(erro);

		} catch (OrderAlocadoException e) {
			e.printStackTrace();
			String erro  = "Esse pedido não esta na posição correta da esteira para executar essa movimentação!";
			throw new OrderAlocadoException(erro);

		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			throw new CamposObrigatoriosException(null,"Campos obrigatórios devem ser preenchidos.");
			
		} catch (RuntimeException e) {

			e.printStackTrace();
			throw new ErroNaoMapeadoException("");
		}

	}

	

	public Order alocar (Order obj) {
		try {
			
			Optional<Order> objAlocado = repository.findById(obj.getId());
			if (objAlocado.get().getStatus().equals("Procurando Alocação")) {
			Usuario prestador = usuarioRepository.findByCpf(obj.getPrestador().getCpf());
			objAlocado.get().setStatus("Alocado");
			objAlocado.get().setPrestador(prestador);
			objAlocado.get().setDataAlocado(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));

			repository.save(objAlocado.get());
			} else {
				throw new OrderAlocadoException("Esse pedido não esta na posição correta da esteira para executar essa movimentação!");

			}
			return obj;

		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			String erro  = "Erro de referência externa. ";
			throw new ReferenciaExternaException(erro);

		} catch (OrderAlocadoException e) {
			e.printStackTrace();
			String erro  = "Esse pedido não esta na posição correta da esteira para executar essa movimentação!";
			throw new OrderAlocadoException(erro);

		} 
		
		catch (ConstraintViolationException e) {
			e.printStackTrace();
			throw new CamposObrigatoriosException(null,"Campos obrigatórios devem ser preenchidos.");
			
		} catch (RuntimeException e) {

			e.printStackTrace();
			throw new ErroNaoMapeadoException("");
		}

	}


	public Order delete(Order obj) {

		try {
			repository.deleteById(obj.getId());
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();

			throw new RecursoNaoEncontradoException("o esse equipamento", obj.getId());

		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();

			throw new RecursoNaoEncontradoException("o esse equipamento", obj.getId());

		}  catch (InvalidDataAccessApiUsageException e) {
			e.printStackTrace();

			throw new CamposObrigatoriosException(null,"O id do recurso a ser deletado deve ser informado.");
			
			
		} catch (RuntimeException e) {
		

			e.printStackTrace();
			throw new ErroNaoMapeadoException("");
		}
		return obj;

	}

}
