package br.com.jantorno.labapi.domain;

public enum Status {
    INATIVO(0), ATIVO(1) ;
	
	private final int status;
	
    Status(int status) { 
    	this.status = status; 
    }
    public int getValue() { 
    	return status; }
}