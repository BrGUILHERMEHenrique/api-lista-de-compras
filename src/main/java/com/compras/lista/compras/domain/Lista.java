package com.compras.lista.compras.domain;

import javax.persistence.*;

@Entity
@Table(name = "Lista")
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Boolean finalizada;
    @Column
    private Double ValorTotal;

    public Lista() {
    }

    public Lista(Long id, Long id_familia, Boolean finalizada, Double valorTotal) {
        this.id = id;
        this.finalizada = finalizada;
        this.ValorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        ValorTotal = valorTotal;
    }
}
