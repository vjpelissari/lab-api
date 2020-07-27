package br.com.jantorno.labapi.services.exeptions;

public class StatusInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusInvalidoException(String mensagem) {
		super(mensagem);
	}
	
	public StatusInvalidoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}