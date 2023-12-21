package com.example.demo;

import java.math.BigDecimal;

public class Produto {

    private String id;
    private String nome;
    private BigDecimal valor;
    private BigDecimal valorTotal;
    private Integer quantidade;

    public Produto() {}

    public Produto(String id, String nome, BigDecimal valor, BigDecimal valorTotal, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.valorTotal = valorTotal;
        this.quantidade = quantidade;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorTotal() {
        return this.getValor().multiply(BigDecimal.valueOf(this.getQuantidade()));
    }

    public String getId() {
        return id;
    }

    public Produto setId(String id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Produto setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Produto setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }
}
