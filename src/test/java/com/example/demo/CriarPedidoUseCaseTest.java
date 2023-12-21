package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CriarPedidoUseCaseTest {

    private CriarPedidoUseCase criarPedidoUseCase;

    @BeforeEach
    public void setup() {
        criarPedidoUseCase = new CriarPedidoUseCase();
    }

    @Test
    public void criarPedidoComSucessoTest() {

        Produto notebook = new Produto()
                .setId("1")
                .setNome("Notebook")
                .setQuantidade(3)
                .setValor(new BigDecimal("2000.00"));

        Produto monitor = new Produto()
                .setId("2")
                .setNome("Monitor")
                .setQuantidade(3)
                .setValor(new BigDecimal("1000.00"));

        List<Produto> produtos = Arrays.asList(notebook, monitor);

        var pedido = criarPedidoUseCase.criarPedido(produtos);

        Assertions.assertEquals(new BigDecimal("9000.00"), pedido.getValorTotaldoPedido());

    }


    @Test
    public void criarPedidoComEstoqueComSucessoTest() {

        Produto notebook = new Produto()
                .setId("1")
                .setNome("Notebook")
                .setQuantidade(3)
                .setValor(new BigDecimal("2000.00"));

        Produto monitor = new Produto()
                .setId("2")
                .setNome("Monitor")
                .setQuantidade(2)
                .setValor(new BigDecimal("1000.00"));

        List<Produto> produtos = Arrays.asList(notebook, monitor);

        var pedido = criarPedidoUseCase.criarPedidoComEstoque(produtos);

        Assertions.assertEquals(new BigDecimal("7000.00"), pedido.getValorTotaldoPedido());
    }
}
