package com.compras.lista.compras.domain;

import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private int qtd;

    @Column
    private Double preco;

    @Column
    private Boolean comprado;

    @ManyToOne
    @JoinColumn(name = "id_lista")
    Lista lista;

    public Item(Long id) {
        this.id = id;
    }

    public Item() {
    }

    public Item(Long id, String nome, int qtd, Double preco, Boolean comprado, Lista lista) {
        this.id = id;
        this.nome = nome;
        this.qtd = qtd;
        this.preco = preco;
        this.comprado = comprado;
        this.lista = lista;
    }

    public Boolean getComprado() {
        return comprado;
    }

    public void setComprado(Boolean comprado) {
        this.comprado = comprado;
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

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
