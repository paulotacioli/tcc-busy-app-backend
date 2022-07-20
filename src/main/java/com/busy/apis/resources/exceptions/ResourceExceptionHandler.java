package com.busy.apis.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.busy.apis.service.exceptions.CamposObrigatoriosException;
import com.busy.apis.service.exceptions.ConexaoComPortalException;
import com.busy.apis.service.exceptions.CorretorNegadoException;
import com.busy.apis.service.exceptions.CorretorPendenteAprovacaoException;
import com.busy.apis.service.exceptions.ErroDePermissaoException;
import com.busy.apis.service.exceptions.ErroDePermissaoNotaException;
import com.busy.apis.service.exceptions.ErroNaoMapeadoException;
import com.busy.apis.service.exceptions.OrderAlocadoException;
import com.busy.apis.service.exceptions.RecursoJaCadastradoException;
import com.busy.apis.service.exceptions.RecursoNaoEncontradoException;
import com.busy.apis.service.exceptions.ReferenciaExternaException;
import com.busy.apis.service.exceptions.SenhasDiferentesException;
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
		String error = "Foram atingidas a quantidade m�xima de notas. Conversar com a equipe de TI para expandir a API de distancias do google.";
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
		String error = "Certifique-se de que campos num�ricos n�o estajam com letras ou caracteres especiais.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ValidacaoTamanhoSenhaException.class)
	public ResponseEntity<StandardError> ValidacaoTamanhoSenhaException(ValidacaoTamanhoSenhaException e, HttpServletRequest request){
		String error = "A senha deve conter no m�ximo 6 caracteres!";
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
		String error = "Senha inv�lida.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(CorretorPendenteAprovacaoException.class)
	public ResponseEntity<StandardError> CorretorPendenteAprovacaoException(CorretorPendenteAprovacaoException e, HttpServletRequest request){
		String error = "Esse CNPJ ainda n�o foi aprovado no sistema. Aguarde contato da administra��o!";
		HttpStatus status = HttpStatus.TOO_EARLY;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(CorretorNegadoException.class)
	public ResponseEntity<StandardError> CorretorNegadoException(CorretorNegadoException e, HttpServletRequest request){
		String error = "Seu pedido de cadastro de transportadora foi negado. Entre em contato com a administra��o!";
		HttpStatus status = HttpStatus.FORBIDDEN;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ViolacaoDeChaveException.class)
	public ResponseEntity<StandardError> ViolacaoDeChaveException(ViolacaoDeChaveException e, HttpServletRequest request){
		String error = "Voc� n�o pode excluir um recurso que esta sendo utilizado pelos usu�rios!";
		HttpStatus status = HttpStatus.FORBIDDEN;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	


	@ExceptionHandler(ErroDePermissaoException.class)
	public ResponseEntity<StandardError> ErroDePermissaoException(ErroDePermissaoException e, HttpServletRequest request){
		String error = "Voc� n�o tem permiss�o para essa nota!";
		HttpStatus status = HttpStatus.FORBIDDEN;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	

	@ExceptionHandler(ConexaoComPortalException.class)
	public ResponseEntity<StandardError> ConexaoComPortalException(ConexaoComPortalException e, HttpServletRequest request){
		String error = "Conex�o com o Portal do Transportador falhou! Tente novamente.";
		HttpStatus status = HttpStatus.BAD_GATEWAY;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
	
	
	@ExceptionHandler(ErroDePermissaoNotaException.class)
	public ResponseEntity<StandardError> ErroDePermissaoNotaException(ErroDePermissaoNotaException e, HttpServletRequest request){
		String error = "Nota inexistente!";
		HttpStatus status = HttpStatus.BAD_GATEWAY;
		StandardError err = new StandardError (Instant.now(), status.value(), error, e.getMessage());
		return ResponseEntity.status(status).body(err);
	}
	
}
