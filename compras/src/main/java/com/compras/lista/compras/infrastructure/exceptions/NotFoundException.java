package com.compras.lista.compras.infrastructure.exceptions;

public class NotFoundException extends Exception{

    private String classe;

    public NotFoundException(String classe) {
        this.classe = classe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe + "Nao encontrado no nosso banco de dados";
    }
}
