package com.dh.pagos;

import com.dh.pagos.model.Cartao;
import com.dh.pagos.model.CartaoCredito;
import com.dh.pagos.model.CartaoDebito;
import com.dh.pagos.model.Tipo;
import com.dh.pagos.service.PagamentoService;
import com.dh.pagos.service.impl.ProcessadorCredito;
import com.dh.pagos.service.impl.ProcessadorDebito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws ParseException {
        // Por exemplo, para evitar a concatenação de ifs, montamos um mapa com as possíveis implementações
        Map<String, PagamentoService> processadoresDePgto = Map.of("Credito", new ProcessadorCredito(), "Debito", new ProcessadorDebito());

        Date dataExpiracao = new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-29");
        Cartao cartaoCredito = new CartaoCredito("1111222233334444", "001", dataExpiracao, Tipo.CREDITO, 300000.0, 60000.0);


        dataExpiracao = new SimpleDateFormat("yyyy-MM-dd").parse("2020-06-29");
        Cartao cartaoDebito = new CartaoDebito("5555666677778888", "002", dataExpiracao, Tipo.DEBITO, 150000.0);

        PagamentoService processadorDePgto = processadoresDePgto.get("Credito");
        System.out.println("Pagamento realizado : " + processadorDePgto.processarPgto(cartaoCredito, 79000.50));
        processadorDePgto = processadoresDePgto.get("Debito");
        System.out.println("Pagamento realizado : " + processadorDePgto.processarPgto(cartaoDebito, 79000.50));
    }
}
