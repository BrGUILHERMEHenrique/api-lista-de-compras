package com.compras.lista.compras.domain;


import javax.persistence.*;

@Entity
@Table(name = "familia")
public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @OneToOne
    @JoinColumn(name = "id_lista")
    private Lista lista;

    public Familia() {
    }

    public Familia(long id, String nome, Lista lista) {
        this.id = id;
        this.nome = nome;
        this.lista = lista;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
