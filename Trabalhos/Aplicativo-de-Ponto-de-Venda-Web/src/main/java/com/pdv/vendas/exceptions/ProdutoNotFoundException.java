package com.pdv.vendas.exceptions;

public class ProdutoNotFoundException extends RuntimeException{

    public ProdutoNotFoundException(String message){
        super(message);
    }
}
