package com.busy.apis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busy.apis.entities.Identifier;
import com.busy.apis.entities.Order;
import com.busy.apis.entities.Usuario;
import com.busy.apis.entities.matrix.paymentSchemas.Bank;
import com.busy.apis.entities.matrix.paymentSchemas.CardPay;
import com.busy.apis.repositories.IdentifierRepository;
import com.busy.apis.repositories.UsuarioRepository;
import com.stripe.Stripe;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.RateLimitException;
import com.stripe.exception.StripeException;
import com.stripe.model.BankAccount;
import com.stripe.model.Card;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentSource;
import com.stripe.model.PaymentSourceCollection;
import com.stripe.model.Token;

@Service
public class PaymentService {
	
	@Autowired
	private IdentifierRepository identifierRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<PaymentSource> listCards(Usuario usuario) {
		Stripe.apiKey = "sk_test_51LNlGMDhqqUuyiSLhj6vNyuWFODkVlTUsE0JbBDTWogIEdX0my43Rlp1qIsMhT1tNoCb9XIRzbz82A0aniNuFiCJ00wettmT3S";
		Identifier objIdentifier = identifierRepository.findByCpf(usuario.getCpf());
		
		try {


			List<String> expandList = new ArrayList<>();
			expandList.add("sources");

			Map<String, Object> retrieveParams = new HashMap<>();
			retrieveParams.put("expand", expandList);

			Customer customer =
			  Customer.retrieve(
					  objIdentifier.getIdCustomer(),
			    retrieveParams,
			    null
			  );

			Map<String, Object> params = new HashMap<>();
			params.put("object", "card");
			params.put("limit", 3);

			PaymentSourceCollection cards =
			  customer.getSources().list(params);
			System.out.println("CARDS"+ cards.toString());
					return cards.getData();

		} catch (CardException e) {
		  // Since it's a decline, CardException will be caught
		  System.out.println("Status is: " + e.getCode());
		  System.out.println("Message is: " + e.getMessage());
		} catch (RateLimitException e) {
			e.printStackTrace();
		  // Too many requests made to the API too quickly
		} catch (InvalidRequestException e) {
			e.printStackTrace();

		  // Invalid parameters were supplied to Stripe's API
		} catch (AuthenticationException e) {
			e.printStackTrace();

		  // Authentication with Stripe's API failed
		  // (maybe you changed API keys recently)
		
		} catch (StripeException e) {
			e.printStackTrace();

		  // Display a very generic error to the user, and maybe send
		  // yourself an email
		} catch (Exception e) {
			e.printStackTrace();

		  // Something else happened, completely unrelated to Stripe
		}
		return null;
		
	}
	
	public String createBankToken(Bank bank) {
		Stripe.apiKey = "sk_test_51LNlGMDhqqUuyiSLhj6vNyuWFODkVlTUsE0JbBDTWogIEdX0my43Rlp1qIsMhT1tNoCb9XIRzbz82A0aniNuFiCJ00wettmT3S";

	
		try {

			Map<String, Object> bankAccount = new HashMap<>();
			bankAccount.put("country", "BR");
			bankAccount.put("currency", "brl");
			bankAccount.put(
			  "account_holder_name",
			  bank.getAccount_holder_name()
			);
			bankAccount.put(
			  "account_holder_type",
			  bank.getAccount_holder_type()
			);
			bankAccount.put("routing_number", bank.getRouting_number());
			bankAccount.put("account_number", bank.getAccount_number());
			Map<String, Object> params = new HashMap<>();
			params.put("bank_account", bankAccount);

			Token token = Token.create(params);
			return token.getId();
		} catch (CardException e) {
		  // Since it's a decline, CardException will be caught
		  System.out.println("Status is: " + e.getCode());
		  System.out.println("Message is: " + e.getMessage());
		} catch (RateLimitException e) {
			e.printStackTrace();
		  // Too many requests made to the API too quickly
		} catch (InvalidRequestException e) {
			e.printStackTrace();

		  // Invalid parameters were supplied to Stripe's API
		} catch (AuthenticationException e) {
			e.printStackTrace();

		  // Authentication with Stripe's API failed
		  // (maybe you changed API keys recently)
		
		} catch (StripeException e) {
			e.printStackTrace();

		  // Display a very generic error to the user, and maybe send
		  // yourself an email
		} catch (Exception e) {
			e.printStackTrace();

		  // Something else happened, completely unrelated to Stripe
		}
		return null;
		
	}
	
	public String createSource(Token token, Usuario usuario) {
		Stripe.apiKey = "sk_test_51LNlGMDhqqUuyiSLhj6vNyuWFODkVlTUsE0JbBDTWogIEdX0my43Rlp1qIsMhT1tNoCb9XIRzbz82A0aniNuFiCJ00wettmT3S";

		Identifier objIdentifier = identifierRepository.findByCpf(usuario.getCpf());
		
		try {

		Map<String, Object> retrieveParams =
		  new HashMap<>();
		List<String> expandList = new ArrayList<>();
		expandList.add("sources");
		retrieveParams.put("expand", expandList);
		Customer customer =
		  Customer.retrieve(
				  objIdentifier.getIdCustomer(),
		    retrieveParams,
		    null
		  );

		Map<String, Object> params = new HashMap<>();
		params.put("source", token.getId());

		Card card =  (Card) customer.getSources().create(params);
		return "Cadastrado com sucesso " + card.getId();

		} catch (CardException e) {
		  // Since it's a decline, CardException will be caught
		  System.out.println("Status is: " + e.getCode());
		  System.out.println("Message is: " + e.getMessage());
		} catch (RateLimitException e) {
			e.printStackTrace();
		  // Too many requests made to the API too quickly
		} catch (InvalidRequestException e) {
			e.printStackTrace();

		  // Invalid parameters were supplied to Stripe's API
		} catch (AuthenticationException e) {
			e.printStackTrace();

		  // Authentication with Stripe's API failed
		  // (maybe you changed API keys recently)
		
		} catch (StripeException e) {
			e.printStackTrace();

		  // Display a very generic error to the user, and maybe send
		  // yourself an email
		} catch (Exception e) {
			e.printStackTrace();

		  // Something else happened, completely unrelated to Stripe
		}
		return null;
		
	}
	
	public String criarPagamento (Order obj, String cardChoosen) {
		Stripe.apiKey = "sk_test_51LNlGMDhqqUuyiSLhj6vNyuWFODkVlTUsE0JbBDTWogIEdX0my43Rlp1qIsMhT1tNoCb9XIRzbz82A0aniNuFiCJ00wettmT3S";

		Identifier objIdentifier = identifierRepository.findByCpf(obj.getUsuario().getCpf());
		System.out.println("Pagamento: "+ obj.getPrecoServico());
		double pagamentoTemp = obj.getPrecoServico()*100;
		Integer pagamentoInteger = (int) (pagamentoTemp);
	

		try {
			
			List<Object> paymentMethodTypes =
					new ArrayList<>();
					paymentMethodTypes.add("card");
					Map<String, Object>	 params = new HashMap<>();
					params.put("amount", pagamentoInteger);
					params.put("confirm", "true");
					params.put("customer", objIdentifier.getIdCustomer());
					params.put("currency", "brl");
					params.put(
					  "payment_method_types",
					  paymentMethodTypes
					);
					params.put("payment_method", cardChoosen);

					PaymentIntent paymentIntent =  PaymentIntent.create(params);
					System.out.println("customer: "+ params.toString());
					System.out.println("paymentIntent: "+ paymentIntent.toString());
				return paymentIntent.getId();
			} catch (CardException e) {
			  // Since it's a decline, CardException will be caught
			  System.out.println("Status is: " + e.getCode());
			  System.out.println("Message is: " + e.getMessage());
			} catch (RateLimitException e) {
				e.printStackTrace();
			  // Too many requests made to the API too quickly
			} catch (InvalidRequestException e) {
				e.printStackTrace();

			  // Invalid parameters were supplied to Stripe's API
			} catch (AuthenticationException e) {
				e.printStackTrace();

			  // Authentication with Stripe's API failed
			  // (maybe you changed API keys recently)
			
			} catch (StripeException e) {
				e.printStackTrace();

			  // Display a very generic error to the user, and maybe send
			  // yourself an email
			} catch (Exception e) {
				e.printStackTrace();

			  // Something else happened, completely unrelated to Stripe
			}
		return null;
	}
	
	public String createCardToken (CardPay obj) {
		Stripe.apiKey = "sk_test_51LNlGMDhqqUuyiSLhj6vNyuWFODkVlTUsE0JbBDTWogIEdX0my43Rlp1qIsMhT1tNoCb9XIRzbz82A0aniNuFiCJ00wettmT3S";

		try {
		Usuario usuario = usuarioRepository.findByCpf(obj.getCpf());
		Map<String, Object> card = new HashMap<>();
		card.put("number", obj.getNumber());
		card.put("exp_month", obj.getExp_month());
		card.put("exp_year", obj.getExp_year());
		card.put("cvc", obj.getCvc());
		Map<String, Object> params = new HashMap<>();
		params.put("card", card);

		Token token = Token.create(params);
		return createSource(token, usuario);
	

		} catch (CardException e) {
		  // Since it's a decline, CardException will be caught
		  System.out.println("Status is: " + e.getCode());
		  System.out.println("Message is: " + e.getMessage());
		} catch (RateLimitException e) {
			e.printStackTrace();
		  // Too many requests made to the API too quickly
		} catch (InvalidRequestException e) {
			e.printStackTrace();

		  // Invalid parameters were supplied to Stripe's API
		} catch (AuthenticationException e) {
			e.printStackTrace();

		  // Authentication with Stripe's API failed
		  // (maybe you changed API keys recently)
		
		} catch (StripeException e) {
			e.printStackTrace();

		  // Display a very generic error to the user, and maybe send
		  // yourself an email
		} catch (Exception e) {
			e.printStackTrace();

		  // Something else happened, completely unrelated to Stripe
		}
	return null;
	}
	
	public Boolean deleteCard (CardPay obj) {
		Stripe.apiKey = "sk_test_51LNlGMDhqqUuyiSLhj6vNyuWFODkVlTUsE0JbBDTWogIEdX0my43Rlp1qIsMhT1tNoCb9XIRzbz82A0aniNuFiCJ00wettmT3S";
		Identifier objIdentifier = identifierRepository.findByCpf(obj.getCpf());
		
		try {

			Map<String, Object> retrieveParams =
			  new HashMap<>();
			List<String> expandList = new ArrayList<>();
			expandList.add("sources");
			retrieveParams.put("expand", expandList);
			Customer customer =
			  Customer.retrieve(
			    objIdentifier.getIdCustomer(),
			    retrieveParams,
			    null
			  );
			
			Card card = (Card) customer.getSources().retrieve(
					    obj.getNumber()
					  );

					Card deletedCard = (Card) card.delete();
	
return deletedCard.getDeleted();
		} catch (CardException e) {
		  // Since it's a decline, CardException will be caught
		  System.out.println("Status is: " + e.getCode());
		  System.out.println("Message is: " + e.getMessage());
		} catch (RateLimitException e) {
			e.printStackTrace();
		  // Too many requests made to the API too quickly
			
		} catch (InvalidRequestException e) {
			e.printStackTrace();

		  // Invalid parameters were supplied to Stripe's API
		} catch (AuthenticationException e) {
			e.printStackTrace();

		  // Authentication with Stripe's API failed
		  // (maybe you changed API keys recently)
		
		} catch (StripeException e) {
			e.printStackTrace();

		  // Display a very generic error to the user, and maybe send
		  // yourself an email
		} catch (Exception e) {
			e.printStackTrace();

		  // Something else happened, completely unrelated to Stripe
		}
	return null;
	}
	
	public String createCustomer (Usuario obj) {


		Stripe.apiKey = "sk_test_51LNlGMDhqqUuyiSLhj6vNyuWFODkVlTUsE0JbBDTWogIEdX0my43Rlp1qIsMhT1tNoCb9XIRzbz82A0aniNuFiCJ00wettmT3S";

		try {

			Map<String, Object> params = new HashMap<>();
			params.put(
			  "description", "Usuário criado pelo busy - app"
			);
			params.put(
			  "name", obj.getNomeCompleto()
			);
			params.put(
			  "email", obj.getEmail()
			);
			params.put(
			  "phone", obj.getCelular()
			);


			Customer customer = Customer.create(params);
			return customer.getId();
			

			} catch (CardException e) {
			  // Since it's a decline, CardException will be caught
			  System.out.println("Status is: " + e.getCode());
			  System.out.println("Message is: " + e.getMessage());
			} catch (RateLimitException e) {
				e.printStackTrace();
			  // Too many requests made to the API too quickly
			} catch (InvalidRequestException e) {
				e.printStackTrace();

			  // Invalid parameters were supplied to Stripe's API
			} catch (AuthenticationException e) {
				e.printStackTrace();

			  // Authentication with Stripe's API failed
			  // (maybe you changed API keys recently)
			
			} catch (StripeException e) {
				e.printStackTrace();

			  // Display a very generic error to the user, and maybe send
			  // yourself an email
			} catch (Exception e) {
				e.printStackTrace();

			  // Something else happened, completely unrelated to Stripe
			}
		return null;
	}

	public String createBankAccount (Bank bank) {
		
		Identifier objIdentifier = identifierRepository.findByCpf(bank.getCpf());
		String bankToken = createBankToken(bank);
		System.out.println("bankToken"+ bankToken);

		Stripe.apiKey = "sk_test_51LNlGMDhqqUuyiSLhj6vNyuWFODkVlTUsE0JbBDTWogIEdX0my43Rlp1qIsMhT1tNoCb9XIRzbz82A0aniNuFiCJ00wettmT3S";

		try {

			Map<String, Object> retrieveParams =
			  new HashMap<>();
			List<String> expandList = new ArrayList<>();
			expandList.add("sources");
			retrieveParams.put("expand", expandList);
			Customer customer =
			  Customer.retrieve(
					  objIdentifier.getIdCustomer(),
			    retrieveParams,
			    null
			  );

			Map<String, Object> params = new HashMap<>();
			params.put(
			  "source",
			  bankToken
			);

			BankAccount bankAccount =
			  (BankAccount) customer.getSources().create(
			    params
			  );

			} catch (CardException e) {
			  // Since it's a decline, CardException will be caught
			  System.out.println("Status is: " + e.getCode());
			  System.out.println("Message is: " + e.getMessage());
			} catch (RateLimitException e) {
				e.printStackTrace();
			  // Too many requests made to the API too quickly
			} catch (InvalidRequestException e) {
				e.printStackTrace();

			  // Invalid parameters were supplied to Stripe's API
			} catch (AuthenticationException e) {
				e.printStackTrace();

			  // Authentication with Stripe's API failed
			  // (maybe you changed API keys recently)
			
			} catch (StripeException e) {
				e.printStackTrace();

			  // Display a very generic error to the user, and maybe send
			  // yourself an email
			} catch (Exception e) {
				e.printStackTrace();

			  // Something else happened, completely unrelated to Stripe
			}
		return null;
	}


}
