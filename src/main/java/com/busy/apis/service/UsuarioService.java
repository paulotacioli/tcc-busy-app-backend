package com.busy.apis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.busy.apis.entities.Identifier;
import com.busy.apis.entities.Usuario;
import com.busy.apis.repositories.IdentifierRepository;
import com.busy.apis.repositories.LoginRepository;
import com.busy.apis.repositories.UsuarioRepository;
import com.busy.apis.service.exceptions.CamposObrigatoriosException;
import com.busy.apis.service.exceptions.RecursoJaCadastradoException;
import com.busy.apis.service.exceptions.RecursoNaoEncontradoException;
import com.busy.apis.service.exceptions.SenhasDiferentesException;
import com.busy.apis.service.exceptions.ValidacaoTamanhoSenhaException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private IdentifierRepository identifierRepository;

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private PaymentService paymentService;
	
	//Optional: Garante que estamos retornando o objeto no banco de dados, não apenas seus valores//

	public Usuario findById(Long cpf) {
		//Optional: Garante que estamos retornando o objeto no banco de dados, não apenas seus valores//
		Optional<Usuario> obj = repository.findById(cpf);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(cpf,1));
	}
	
	public Usuario findByCpf(Long cpf) {
		//Optional: Garante que estamos retornando o objeto no banco de dados, não apenas seus valores//
		Usuario obj = repository.findByCpf(cpf);
		return obj;
	}
	
	public Usuario insert (Usuario obj) {
	if (obj.getSenha().toString().equals(obj.getSenhaConfirm().toString())) {
			
		if(repository.existsById(obj.getCpf())){
			throw new RecursoJaCadastradoException(obj.getCpf().toString(),1);
		} else {
			if (obj.getSenha().length() > 5) {
			try {
				Usuario objEcp = new Usuario ();
				objEcp = obj;
				objEcp.setSenha(new BCryptPasswordEncoder().encode(obj.getSenha()));
				objEcp.setSenhaConfirm(new BCryptPasswordEncoder().encode(obj.getSenhaConfirm()));	

				loginService.saveLoginCorretor(objEcp);
				repository.save(objEcp);
				Identifier objIdentifer = new Identifier();
				objIdentifer.setCpf(obj.getCpf());
				objIdentifer.setIdCustomer(paymentService.createCustomer(obj));
				identifierRepository.save(objIdentifer);

							
			}catch (DataIntegrityViolationException e) {
					e.printStackTrace();
			       throw new RecursoJaCadastradoException(obj.getCpf().toString(),1);
			       
				} catch (TransactionSystemException e) {
					System.out.println("2");

					e.printStackTrace();	
					e.getCause().getStackTrace();
					throw new CamposObrigatoriosException (obj, e.getMostSpecificCause().toString());
				} catch (JpaSystemException e) {
					System.out.println("3");

					e.printStackTrace();
					throw new CamposObrigatoriosException (obj, e.getMostSpecificCause().toString());
				} 
				} else {
					throw new ValidacaoTamanhoSenhaException ("A senha deve conter no mínimo 6 caracteres!");
				}
				}
	} else {
		throw new SenhasDiferentesException ("Senhas no cadastro de corretores não estão iguais.");
	}
		
		return obj;
	}
	
	
}
