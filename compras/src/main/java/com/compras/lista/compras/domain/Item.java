package com.compras.lista.compras.domain;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private int qtd;

    @Column
    private Double preco;

    public item() {
    }

    public item(Long id, String nome, int qtd, Double preco) {
        this.id = id;
        this.nome = nome;
        this.qtd = qtd;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
