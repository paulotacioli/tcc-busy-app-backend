package com.busy.apis.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.busy.apis.entities.Login;
import com.busy.apis.entities.Usuario;
import com.busy.apis.service.LoginService;
import com.busy.apis.service.UsuarioService;
import com.busy.apis.service.exceptions.ServidorNegadoException;
import com.busy.apis.service.exceptions.ServidorPendenteAprovacaoException;
import com.busy.apis.service.exceptions.ErroNaoMapeadoException;
import com.busy.apis.service.exceptions.UsuarioInvalidoException;

@RestController
@CrossOrigin
@EnableWebSecurity
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private LoginService loginService;
	@Autowired
	private UsuarioService corretorService;
	
	private Usuario usuarioAprovado;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		usuarioAprovado = new Usuario ();
		
		usuarioAprovado = corretorService.findById(authenticationRequest.getCpf());
		
		
		authenticate1(authenticationRequest.getCpf(), authenticationRequest.getSenha());
		final Login login = loginService.findByCpf(authenticationRequest.getCpf());
		final String token = jwtTokenUtil.generateToken(login);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate1(Long cpf, String senha) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(cpf, senha));

		} catch (DisabledException e) {

			throw new Exception("USER_DISABLED", e);
			
		} catch (BadCredentialsException e) {
			throw new UsuarioInvalidoException("");
		} catch (RuntimeException e) {
			throw new ErroNaoMapeadoException ("");
		}
	}
}