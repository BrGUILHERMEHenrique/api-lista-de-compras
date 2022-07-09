package com.compras.lista.compras.infrastructure.exceptions;

public class UsuarioNotFoundException extends Exception{

    private String msg;

    public UsuarioNotFoundException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
