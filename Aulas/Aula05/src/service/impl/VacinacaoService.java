package service.impl;

import model.Pessoa;
import service.IVacinacao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VacinacaoService implements IVacinacao {


    @Override
    public void vacinar(Pessoa pessoa) {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtualFormatada = formato.format(new Date());

        System.out.println(pessoa.getNome() + " portador do RG: " + pessoa.getRg()
        + " tomou a vacina " + pessoa.getVacina() + " no dia " + dataAtualFormatada);

    }
}
