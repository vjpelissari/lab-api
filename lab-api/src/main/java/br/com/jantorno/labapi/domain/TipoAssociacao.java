package br.com.jantorno.labapi.domain;

public enum TipoAssociacao {

    DESASSOCIAR(0), ASSOCIAR(1);
	
	private final int tipo;
	
	TipoAssociacao(int tipo) { 
    	this.tipo = tipo; 
    }
    public int getValue() { 
    	return tipo; 
    }
}