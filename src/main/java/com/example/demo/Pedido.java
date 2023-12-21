package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    List<Produto> produtos = new ArrayList<>();
    BigDecimal valorTotaldoPedido;

    List<Produto> estoque = new ArrayList<>();

    public Pedido() {}

    public Pedido(List<Produto> produtos, BigDecimal valorTotaldoPedido, List<Produto> estoque) {
        this.produtos = produtos;
        this.valorTotaldoPedido = valorTotaldoPedido;
        this.estoque = estoque;
    }

    public List<Produto> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<Produto> estoque) {
        this.estoque = estoque;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Pedido setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }

    public BigDecimal getValorTotaldoPedido() {
        return valorTotaldoPedido;
    }

    public Pedido setValorTotaldoPedido(BigDecimal valorTotaldoPedido) {
        this.valorTotaldoPedido = valorTotaldoPedido;
        return this;
    }
}
