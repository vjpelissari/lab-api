package br.com.jantorno.labapi.domain;

public class LabsExame {

	private Long idLaboratorio;
	private Long idExame;
	private TipoAssociacao tipo;
	
	public Long getIdLaboratorio() {
		return idLaboratorio;
	}

	public void setIdLaboratorio(Long idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public Long getIdExame() {
		return idExame;
	}

	public void setIdExame(Long idExame) {
		this.idExame = idExame;
	}

	public TipoAssociacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoAssociacao tipo) {
		this.tipo = tipo;
	}
}