package br.com.jantorno.labapi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.jantorno.labapi.domain.DetalhesErro;

import br.com.jantorno.labapi.services.exeptions.*;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(LaboratorioNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleLaboratorioNaoEncontradoException
							(LaboratorioNaoEncontradoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O laboratório não foi encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.labapi.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(ExameNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleExameNaoEncontradoException
							(ExameNaoEncontradoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O exame não foi encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.labapi.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(NomeLaboratorioExistenteException.class)
	public ResponseEntity<DetalhesErro> handleNomeLaboratorioExistenteException
							(NomeLaboratorioExistenteException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Nome do laboratório existente.");
		erro.setMensagemDesenvolvedor("http://erros.labapi.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}	
	
	@ExceptionHandler(NomeExameExistenteException.class)
	public ResponseEntity<DetalhesErro> handleNomeExameExistenteException
							(NomeExameExistenteException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Nome do exame existente.");
		erro.setMensagemDesenvolvedor("http://erros.labapi.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(StatusInvalidoException.class)
	public ResponseEntity<DetalhesErro> handleStatusInvalidoException
							(StatusInvalidoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(406l);
		erro.setTitulo("Status Inválido. Escolha entre: 1 - Ativo; 0 - Inativo");
		erro.setMensagemDesenvolvedor("http://erros.labapi.com/406");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(erro);
	}	
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<DetalhesErro> handleHttpMessageNotReadableException
							(HttpMessageNotReadableException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(406l);
		erro.setTitulo("Erro na entrada de dados.");
		erro.setMensagemDesenvolvedor("http://erros.labapi.com/406");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(erro);
	}	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException
							(DataIntegrityViolationException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Dados Existentes.");
		erro.setMensagemDesenvolvedor("http://erros.labapi.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}	
}