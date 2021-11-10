package com.digitalhouse.interfac;


import com.digitalhouse.model.Cartao;
import com.digitalhouse.model.Produto;

public interface IDesconto {
    Double calcularDesconto(Cartao cartao, Produto produto, Integer quantidade);

}
