package com.busy.apis.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.busy.apis.service.exceptions.CamposObrigatoriosException;
import com.busy.apis.service.exceptions.ErroNaoMapeadoException;
import com.busy.apis.service.exceptions.OrderAlocadoException;
import com.busy.apis.service.exceptions.RecursoJaCadastradoException;
import com.busy.apis.service.exceptions.RecursoNaoEncontradoException;
import com.busy.apis.service.exceptions.ReferenciaExternaException;
import com.busy.apis.service.exceptions.SenhasDiferentesException;
import com.busy.apis.service.exceptions.ServidorNegadoException;
import com.busy.apis.service.exceptions.ServidorPendenteAprovacaoException;
import com.busy.apis.service.exceptions.TamanhoMaximoException;
import com.busy.apis.service.exceptions.UsuarioInvalidoException;
import com.busy.apis.service.exceptions.ValidacaoTamanhoSenhaException;
import com.busy.apis.service.exceptions.ViolacaoDeChaveException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<StandardError> resourceNotFound(RecursoNaoEncontradoException e, HttpServletRequest request){
		String error = "Recurso não encontrado.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(OrderAlocadoException.class)
	public ResponseEntity<StandardError> OrderAlocadoException(OrderAlocadoException e, HttpServletRequest request){
		String error = "Esse pedido não esta na posição correta da esteira para executar essa movimentação!";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(RecursoJaCadastradoException.class)
	public ResponseEntity<StandardError> RecursoJaCadastradoException(RecursoJaCadastradoException e, HttpServletRequest request){
		String error = "Esse recurso já foi cadastrado.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(CamposObrigatoriosException.class)
	public ResponseEntity<StandardError> ViolationException(CamposObrigatoriosException e, HttpServletRequest request){
		String error = "Campos obrigatórios devem ser preenchidos.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ReferenciaExternaException.class)
	public ResponseEntity<StandardError> AccessApiUsageException(ReferenciaExternaException e, HttpServletRequest request){
		String error = "Problemas de referência com outras entidades.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(TamanhoMaximoException.class)
	public ResponseEntity<StandardError> TamanhoMaximoException(TamanhoMaximoException e, HttpServletRequest request){
		String error = "Foram atingidas a quantidade máxima de destinos que podem ser cadastrados. Essa é uma validação do google, favor diminuir quantidade de destinos e tentar novamente.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ErroNaoMapeadoException.class)
	public ResponseEntity<StandardError> ErroNaoMapeadoException(ErroNaoMapeadoException e, HttpServletRequest request){
		String error = "Erro n�o mapeado. Favor tentar mais tarde, em caso de persistencia contatar a equipe de TI.";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<StandardError> HttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request){
		String error = "Certifique-se de que campos numéricos não estajam com letras ou caracteres especiais.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ValidacaoTamanhoSenhaException.class)
	public ResponseEntity<StandardError> ValidacaoTamanhoSenhaException(ValidacaoTamanhoSenhaException e, HttpServletRequest request){
		String error = "A senha deve conter no máximo 6 caracteres!";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(SenhasDiferentesException.class)
	public ResponseEntity<StandardError> SenhasDiferentesException(SenhasDiferentesException e, HttpServletRequest request){
		String error = "Atenção! As senhas estão diferentes.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(UsuarioInvalidoException.class)
	public ResponseEntity<StandardError> UsuarioInvalidoException(UsuarioInvalidoException e, HttpServletRequest request){
		String error = "Senha inválida.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ServidorPendenteAprovacaoException.class)
	public ResponseEntity<StandardError> ServidorPendenteAprovacaoException(ServidorPendenteAprovacaoException e, HttpServletRequest request){
		String error = "Esse cadastro como servidor ainda não foi aprovado no nosso sistema!";
		HttpStatus status = HttpStatus.TOO_EARLY;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ServidorNegadoException.class)
	public ResponseEntity<StandardError> ServidorNegadoException(ServidorNegadoException e, HttpServletRequest request){
		String error = "Seu pedido de cadastro como servidor foi negado. Entre em contato com a administração!";
		HttpStatus status = HttpStatus.FORBIDDEN;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ViolacaoDeChaveException.class)
	public ResponseEntity<StandardError> ViolacaoDeChaveException(ViolacaoDeChaveException e, HttpServletRequest request){
		String error = "Você não pode excluir um recurso que esta sendo utilizado pelos usuários!";
		HttpStatus status = HttpStatus.FORBIDDEN;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	

	
}
