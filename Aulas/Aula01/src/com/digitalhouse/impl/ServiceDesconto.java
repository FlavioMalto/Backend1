package com.digitalhouse.impl;

import com.digitalhouse.exapi.ApiCartao;
import com.digitalhouse.exapi.ApiProduto;
import com.digitalhouse.exapi.ApiQuantidade;
import com.digitalhouse.interfac.IDesconto;
import com.digitalhouse.model.Cartao;
import com.digitalhouse.model.Produto;

public class ServiceDesconto implements IDesconto {
    private ApiCartao apiCartao = new ApiCartao();
    private ApiProduto apiProduto = new ApiProduto();
    private ApiQuantidade apiQuantidade = new ApiQuantidade();



    @Override
    public Double calcularDesconto(Cartao cartao, Produto produto, Integer quantidade) {
        Double desconto = 0.0;
        desconto += apiCartao.checkDesconto(cartao.getBanco())
                + apiProduto.checkDesconto(produto.getTipo())
                + apiQuantidade.checkDesconto(quantidade);
        return desconto;
    }
}
