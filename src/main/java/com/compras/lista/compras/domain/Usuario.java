package com.compras.lista.compras.domain;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String senha;
    @OneToOne
    @JoinColumn(name = "id_familia")
    private Familia familia;

    public Usuario() {
    }

    public Usuario(long id) {
        this.id = id;
    }

    public Usuario(long id, String nome, String email, String senha, Familia familia) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.familia = familia;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
}
