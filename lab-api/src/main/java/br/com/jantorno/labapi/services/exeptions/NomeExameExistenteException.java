package br.com.jantorno.labapi.services.exeptions;

public class NomeExameExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NomeExameExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public NomeExameExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}