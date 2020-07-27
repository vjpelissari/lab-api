package br.com.jantorno.labapi.domain;

public enum TipoExame {
    ANALISE(0), IMAGEM(1) ;
	
	private final int tipo;
	
    TipoExame(int status) { 
    	this.tipo = status; 
    }
    public int getValue() { 
    	return tipo; 
    }
}