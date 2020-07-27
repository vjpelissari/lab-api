package br.com.jantorno.labapi.services.exeptions;

public class LaboratorioNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1869300553614629710L;

	public LaboratorioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public LaboratorioNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}