package com.example.demo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriarPedidoUseCase {

    Map<String, Produto> estoque = new HashMap<>();


    public Pedido criarPedido(List<Produto> produtos) {

        Pedido novoPedido = new Pedido();
        novoPedido.setProdutos(produtos);
        novoPedido.setValorTotaldoPedido(calcularValorTotalDoPedido(produtos));

        return novoPedido;

    }

    public Pedido criarPedidoComEstoque(List<Produto> produtos) {

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

        Map<String, Produto> estoque = new HashMap<>();
        estoque.put(notebook.getId(), notebook);
        estoque.put(monitor.getId(), monitor);

        for (Produto produto : produtos) {
            if (!estoque.containsKey(produto.getId())) {
                throw new RuntimeException("Produto não cadastrado no estoque!");
            }

            atualizarQuantidade(produto, estoque);
        }

        Pedido novoPedido = new Pedido();
        novoPedido.setProdutos(produtos);
        novoPedido.setValorTotaldoPedido(calcularValorTotalDoPedido(produtos));
        novoPedido.setEstoque(estoque.values().stream().toList());

        return novoPedido;

    }

    private void atualizarQuantidade(Produto produto, Map<String, Produto> estoque) {
        Produto produtoEmEstoque = estoque.get(produto.getId());

        if (produto.getQuantidade() > produtoEmEstoque.getQuantidade()) {
            throw new RuntimeException("Quantidade excedida para o produto: " + produto.getNome());
        }

        var produtoAtualizado = new Produto();
        produtoAtualizado.setId(produto.getId());
        produtoAtualizado.setNome(produto.getNome());
        produtoAtualizado.setValor(produto.getValor());
        produtoAtualizado.setQuantidade(produtoEmEstoque.getQuantidade() - produto.getQuantidade());

        estoque.put(produto.getId(), produtoAtualizado);
    }

    private BigDecimal calcularValorTotalDoPedido(List<Produto> produtos) {

        produtos.forEach(produto -> {
            produto.setValorTotal(produto.getValor().multiply(BigDecimal.valueOf(produto.getQuantidade())));
        });

        return produtos.stream()
                .map(Produto::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
