package br.com.jantorno.labapi.services.exeptions;

public class ExameNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1869300553614629710L;

	public ExameNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ExameNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}