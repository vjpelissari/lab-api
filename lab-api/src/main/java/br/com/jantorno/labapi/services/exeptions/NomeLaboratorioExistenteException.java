package br.com.jantorno.labapi.services.exeptions;

public class NomeLaboratorioExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NomeLaboratorioExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public NomeLaboratorioExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}