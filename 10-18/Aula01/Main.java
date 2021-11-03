package aula01.aulaSincrona;

import aula01.aulaSincrona.impl.ServiceDesconto;
import aula01.aulaSincrona.modal.Cartao;
import aula01.aulaSincrona.modal.Produto;

public class Main {
    public static void main(String[] args) {
        Cartao cartao = new Cartao("1234567890", "Star Bank");
        Produto produto = new Produto("Leite", "latas");

        ServiceDesconto service = new ServiceDesconto();

        System.out.println(service.calcularDesconto(cartao, produto, 13));
    }
}
