/*
 * package com.busy.apis.service;
 * 
 * import java.io.IOException; import java.util.ArrayList; import
 * java.util.HashSet; import java.util.List; import java.util.Optional; import
 * java.util.Set;
 * 
 * import javax.persistence.EntityNotFoundException; import
 * javax.validation.ConstraintViolationException;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.dao.DataIntegrityViolationException; import
 * org.springframework.dao.InvalidDataAccessApiUsageException; import
 * org.springframework.stereotype.Service; import
 * org.springframework.transaction.TransactionSystemException;
 * 
 * import com.busy.apis.entities.AprovacaoMotorista; import
 * com.busy.apis.entities.Motorista; import
 * com.busy.apis.entities.Transportadora; import
 * com.busy.apis.entities.matrix.RequestLoginMotorista; import
 * com.busy.apis.entities.matrix.ResponseLoginMotorista; import
 * com.busy.apis.repositories.AprovacaoMotoristaRepository; import
 * com.busy.apis.repositories.MotoristaRepository; import
 * com.busy.apis.repositories.ProprietarioRepository; import
 * com.busy.apis.repositories.TransportadoraRepository; import
 * com.busy.apis.service.exceptions.CamposObrigatoriosException; import
 * com.busy.apis.service.exceptions.ErroNaoMapeadoException; import
 * com.busy.apis.service.exceptions.RecursoJaCadastradoException;
 * import
 * com.busy.apis.service.exceptions.RecursoNaoEncontradoException;
 * import com.busy.apis.service.exceptions.ReferenciaExternaException;
 * import com.google.gson.Gson;
 * 
 * import okhttp3.MediaType; import okhttp3.MultipartBody; import
 * okhttp3.OkHttpClient; import okhttp3.Request; import okhttp3.RequestBody;
 * import okhttp3.Response;
 * 
 * @Service public class MotoristaService {
 * 
 * 
 * @Autowired private MotoristaRepository repository;
 * 
 * @Autowired private ProprietarioRepository repositoryProprietario;
 * 
 * @Autowired private TransportadoraRepository repositoryCorretor;
 * 
 * @Autowired private AprovacaoMotoristaRepository aprovacaoRepository;
 * 
 * public List<Motorista> findAll(){ return repository.findAll();
 * 
 * }
 * 
 * public List<Motorista> findAllByTransportadoraCnpj(Long cnpj){ return
 * repository.findAllByTransportadoraCnpj(cnpj);
 * 
 * } public List<Motorista> encontrarMotoristasPendentes(Long cnpj){
 * List<Motorista> obj = repository.findAllByTransportadoraCnpj(cnpj);
 * List<Motorista> pendentes = new ArrayList<Motorista>(); for (Motorista
 * objAtual : obj) { AprovacaoMotorista aprovado = new AprovacaoMotorista();
 * 
 * aprovado = aprovacaoRepository.findByCnpjTransportadoraAndCpfMotorista(cnpj,
 * objAtual.getCpf());
 * 
 * if (aprovado.getAprovado() == 0) { pendentes.add(objAtual);
 * 
 * }
 * 
 * 
 * 
 * }
 * 
 * 
 * return pendentes;
 * 
 * }
 * 
 * public int consultarAprovacao(RequestLoginMotorista obj){ AprovacaoMotorista
 * obj2 =
 * aprovacaoRepository.findByCnpjTransportadoraAndCpfMotorista(Long.parseLong(
 * obj.getCnpj_transportadora()), obj.getCpf_motorista());
 * 
 * return obj2.getAprovado();
 * 
 * 
 * 
 * 
 * }
 * 
 * public String criarLoginMotorista(RequestLoginMotorista obj) throws
 * IOException{
 * 
 * if (obj.getAprovado() == 3 ) {
 * 
 * AprovacaoMotorista objAprovaMoto = new AprovacaoMotorista(); objAprovaMoto =
 * aprovacaoRepository.findByCnpjTransportadoraAndCpfMotorista(Long.parseLong(
 * obj.getCnpj_transportadora()), obj.getCpf_motorista());
 * objAprovaMoto.setAprovado(3); aprovacaoRepository.save(objAprovaMoto);
 * 
 * }
 * 
 * AprovacaoMotorista objAprovaMotoAntes = new AprovacaoMotorista();
 * 
 * objAprovaMotoAntes =
 * aprovacaoRepository.findByCnpjTransportadoraAndCpfMotorista(Long.parseLong(
 * obj.getCnpj_transportadora()), obj.getCpf_motorista());
 * 
 * 
 * System.out.println("aprova��o repository depois"+
 * objAprovaMotoAntes.toString()); if (objAprovaMotoAntes.getAprovado() == 0) {
 * 
 * 
 * OkHttpClient client = new OkHttpClient().newBuilder() .build(); MediaType
 * mediaType = MediaType.parse("text/plain"); RequestBody body = new
 * MultipartBody.Builder().setType(MultipartBody.FORM) .addFormDataPart("nome",
 * obj.getNome()) .addFormDataPart("email", obj.getEmail())
 * .addFormDataPart("cnpj_transportadora", obj.getCnpj_transportadora())
 * .addFormDataPart("password", obj.getPassword()) .addFormDataPart("placa",
 * obj.getPlaca()) .build(); Request request = new Request.Builder() .url(
 * "https://qa.portaldotransportador.com/externo/api/ws/alocaja/new_motorista/post")
 * .method("POST", body) .addHeader("apiKey",
 * "78asd4546d4sa687e1d1xzlcknhwyhuWMKPSJDpox8213njdOWnxxipW58547")
 * .addHeader("Cookie", "ci_session=6d75q7dr6nlnq2ntu06g539gsfjvsqra") .build();
 * Response response2 = client.newCall(request).execute();
 * System.out.println("RESPONSE 2"+ response2); String response =
 * response2.body().string();
 * 
 * System.out.println("response"+response); ResponseLoginMotorista responseLogin
 * = new ResponseLoginMotorista(); Gson gson = new Gson();
 * 
 * String jsonString = gson.toJson(response); System.out.println("RESPONSE 2"+
 * response.toString()); responseLogin = gson.fromJson(response.toString(),
 * ResponseLoginMotorista.class);
 * 
 * System.out.println("responseLogin 2"+ responseLogin.toString()); if
 * (responseLogin.isSuccess() == true) { System.out.println("IF");
 * 
 * AprovacaoMotorista objAprovaMoto = new AprovacaoMotorista(); objAprovaMoto =
 * aprovacaoRepository.findByCnpjTransportadoraAndCpfMotorista(Long.parseLong(
 * obj.getCnpj_transportadora()), obj.getCpf_motorista());
 * objAprovaMoto.setAprovado(1); aprovacaoRepository.save(objAprovaMoto);
 * 
 * return "Conta criada com sucesso! Username:" + responseLogin.getUsername() +
 * " e senha: " + responseLogin.getPassword(); } else {
 * System.out.println("ELSES"); return responseLogin.getMessage();
 * 
 * }
 * 
 * } else { return "J� aprovado para essa transportadora!"; }
 * 
 * }
 * 
 * 
 * 
 * public Motorista atualizarMotorista(Motorista obj){ try {
 * 
 * Motorista entity = repository.findByCpf(obj.getCpf());
 * entity.setNomeCompleto(obj.getNomeCompleto());
 * entity.setNumeroCnh(obj.getNumeroCnh()); entity.setNumero(obj.getNumero());
 * entity.setLogradouro(obj.getLogradouro()); entity.setCidade(obj.getCidade());
 * entity.setBairro(obj.getBairro()); entity.setEstado(obj.getEstado());
 * entity.setEmail(obj.getEmail()); entity.setCelular(obj.getCelular());
 * entity.setCep(obj.getCep()); if (obj.getTipoVeiculo().size() >= 1) {
 * entity.setTipoVeiculo(obj.getTipoVeiculo()); }
 * 
 * 
 * return repository.save(entity);
 * 
 * 
 * } catch (TransactionSystemException e) {
 * 
 * throw new CamposObrigatoriosException ("Existem campos vazios!", null);
 * 
 * } catch (EntityNotFoundException e) { throw new RecursoNaoEncontradoException
 * ("O recurso a ser aprovado não existe na base. Atualize a página e tente novamente."
 * ,1); } catch (RuntimeException e) { e.printStackTrace(); throw new
 * ErroNaoMapeadoException("Erro não mapeado na aprovação de corretores."); } }
 * 
 * 
 * 
 * public Motorista findById(Long id) { Optional<Motorista> obj =
 * repository.findById(id); return obj.orElseThrow(() -> new
 * RecursoNaoEncontradoException(id,1)); }
 * 
 * public AnuncioResumoCard findAllProjectedByIdServico(Long id) {
 * AnuncioResumoCard obj = repository.findProjectedById(id); return obj; }
 * 
 * 
 * 
 * 
 * 
 * public List<AnunciosFiltrados> filtrar (AnuncioFiltro obj) {
 * 
 * if (obj.getCidade().length() >0 ) { if (obj.getTipoImovel() == null) {
 * 
 * List<AnunciosFiltrados> anunciosFiltrados1 = repository.
 * findAllProjectedByBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThanAndRegiaoCidade
 * (obj.getBanheiros(), obj.getDormitorios(), obj.getVagas(),
 * obj.getAreaPrivada(), obj.getValorImovel(), obj.getCidade()); return
 * anunciosFiltrados1;
 * 
 * } else {
 * 
 * List<AnunciosFiltrados> anunciosFiltrados1 = repository.
 * findAllProjectedByTipoImovelAndBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThanAndRegiaoCidade
 * (obj.getTipoImovel(), obj.getBanheiros(), obj.getDormitorios(),
 * obj.getVagas(), obj.getAreaPrivada(), obj.getValorImovel(), obj.getCidade());
 * return anunciosFiltrados1;
 * 
 * }
 * 
 * 
 * } else {
 * 
 * if (obj.getRegiao().isEmpty()) { if (obj.getTipoImovel() == null) {
 * List<AnunciosFiltrados> anunciosFiltrados2 = repository.
 * findAllProjectedByBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThan
 * (obj.getBanheiros(), obj.getDormitorios(), obj.getVagas(),
 * obj.getAreaPrivada(), obj.getValorImovel()); return anunciosFiltrados2; }
 * else { List<AnunciosFiltrados> anunciosFiltrados2 = repository.
 * findAllProjectedByTipoImovelAndBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThan
 * (obj.getTipoImovel(),obj.getBanheiros(), obj.getDormitorios(),
 * obj.getVagas(), obj.getAreaPrivada(), obj.getValorImovel()); return
 * anunciosFiltrados2; } } else { if (obj.getTipoImovel() == null) {
 * List<AnunciosFiltrados> anunciosFiltrados2 = repository.
 * findAllProjectedByBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThanAndRegiaoIn
 * (obj.getBanheiros(), obj.getDormitorios(), obj.getVagas(),
 * obj.getAreaPrivada(), obj.getValorImovel(), obj.getRegiao()); return
 * anunciosFiltrados2;
 * 
 * } else { List<AnunciosFiltrados> anunciosFiltrados2 = repository.
 * findAllProjectedByTipoImovelAndBanheirosGreaterThanAndDormitoriosGreaterThanAndVagasGreaterThanAndAreaPrivadaGreaterThanAndValorImovelLessThanAndRegiaoIn
 * (obj.getTipoImovel(),obj.getBanheiros(), obj.getDormitorios(),
 * obj.getVagas(), obj.getAreaPrivada(), obj.getValorImovel(), obj.getRegiao());
 * return anunciosFiltrados2; } }
 * 
 * 
 * }
 * 
 * 
 * }
 * 
 * 
 * public Motorista insert (Motorista obj) { if
 * (repository.findByCpf(obj.getCpf()) != null) { throw new
 * RecursoJaCadastradoException ("N�o existe esse registro.",1); } else { try {
 * Set<Transportadora> trans = new HashSet<>();
 * 
 * trans = obj.getTransportadora(); if (trans.size() == 0) { AprovacaoMotorista
 * aprovPadrao = new AprovacaoMotorista(Long.parseLong("11111111111111"),
 * obj.getCpf(), 0); aprovacaoRepository.save(aprovPadrao); } else { for
 * (Transportadora objAtual : trans ) {
 * 
 * AprovacaoMotorista aprov = new AprovacaoMotorista(objAtual.getCnpj(),
 * obj.getCpf(), 0); aprovacaoRepository.save(aprov);
 * 
 * } }
 * 
 * obj.setAprovado(false); repository.save(obj);
 * 
 * } catch (DataIntegrityViolationException e) { //System.out.println("erro 0");
 * //e.printStackTrace(); throw new
 * ReferenciaExternaException(obj.getId().toString());
 * 
 * } catch (TransactionSystemException e) { //System.out.println("erro 1");
 * //e.printStackTrace(); throw new CamposObrigatoriosException (obj,
 * e.getMostSpecificCause().toString());
 * 
 * } catch (ConstraintViolationException e) { //System.out.println("erro 2");
 * //e.printStackTrace(); throw new CamposObrigatoriosException (obj,
 * e.getLocalizedMessage());
 * 
 * } catch (InvalidDataAccessApiUsageException e) {
 * //System.out.println("errinho"); //e.printStackTrace(); throw new
 * ReferenciaExternaException (e.getLocalizedMessage());
 * 
 * } catch (RuntimeException e) { e.printStackTrace(); throw new
 * ErroNaoMapeadoException (""); } }
 * 
 * return obj; }
 * 
 * public Motorista insertCliente (Motorista obj) {
 * System.out.println("entrou111"); Corretor corr = obj.getCorretor();
 * Proprietario prop = obj.getProprietario(); System.out.println("ENTROU2222");
 * 
 * System.out.println("o proprietario existe"+
 * repositoryProprietario.existsById(prop.getCpf()));
 * System.out.println("ENTROU2222.1");
 * 
 * 
 * if (!repositoryCorretor.existsById(corr.getCpf())) {
 * System.out.println("ENTROU2333");
 * 
 * throw new NaoExisteEsseCorretorException
 * ("Esse CPF de corretor não existe em nossa base. Converse com seu corretor ou selecione a opção 'Ainda não tenho um corretor da IMBECKER'!"
 * );
 * 
 * }
 * 
 * if (repositoryProprietario.existsById(prop.getCpf()) &&
 * (!(obj.getProprietario().getEmail() == null) ||
 * !(obj.getProprietario().getTelefone() == null) ||
 * !(obj.getProprietario().getNome()==null)) ){
 * 
 * System.out.
 * println("PROPRIETARIOSERVICE: Não é o primeiro anuncio para esse cpf"); throw
 * new NaoEPrimeiroAnuncioException ("Não é o primeiro anúncio para esse CPF.");
 * }else if(repositoryProprietario.existsById(prop.getCpf())){
 * System.out.println("ENTROU777");
 * 
 * try { System.out.println("ENTROU888");
 * 
 * repository.save(obj); System.out.println("OBJETO:"+ obj);
 * System.out.println("OBJETO RESPONSE:"+ obj);
 * 
 * System.out.println("ENTROU999");
 * 
 * } catch (DataIntegrityViolationException e) {
 * 
 * throw new AccessApiUsageException(obj.getId().toString());
 * 
 * } catch (TransactionSystemException e) {
 * 
 * throw new ViolationException (obj, e.getMostSpecificCause().toString());
 * 
 * } catch (ConstraintViolationException e) {
 * 
 * throw new ViolationException (obj, e.getLocalizedMessage());
 * 
 * } catch (InvalidDataAccessApiUsageException e) {
 * 
 * throw new AccessApiUsageException (e.getLocalizedMessage());
 * 
 * } catch (RuntimeException e) { e.printStackTrace();
 * System.out.println("passou aqui 2");
 * 
 * throw new ErroNaoMapeadoException (""); } } else {
 * System.out.println("ENTROU555");
 * 
 * try { System.out.println("ENTROU12");
 * 
 * repositoryProprietario.save(prop); System.out.println("ENTRANDO 888111");
 * repository.save(obj);
 * 
 * System.out.println("ENTROU666");
 * 
 * } catch (DataIntegrityViolationException e) { //System.out.println("erro 0");
 * //e.printStackTrace(); throw new
 * AccessApiUsageException(obj.getId().toString());
 * 
 * } catch (TransactionSystemException e) { //System.out.println("erro 1");
 * //e.printStackTrace(); throw new FaltaDadosProprietarioException
 * ("Como é o primeiro anúncio nesse CPF, é necessário ativar a função 'É meu primeiro imóvel na IMBECKER' e cadastrar o nome, telefone e email do proprietário."
 * );
 * 
 * } catch (ConstraintViolationException e) { //System.out.println("erro 2");
 * //e.printStackTrace(); throw new ViolationException (obj,
 * e.getLocalizedMessage());
 * 
 * } catch (InvalidDataAccessApiUsageException e) {
 * //System.out.println("errinho"); //e.printStackTrace(); throw new
 * AccessApiUsageException (e.getLocalizedMessage());
 * 
 * } catch (RuntimeException e) { e.printStackTrace();
 * System.out.println("passou aqui 2");
 * 
 * throw new ErroNaoMapeadoException (""); } }
 * 
 * 
 * 
 * System.out.println("RETURN OBJETO:" + obj); return obj;
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */