import model.Pessoa;
import service.IVacinacao;
import service.impl.VacinacaoProxy;
import service.impl.VacinacaoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formatoData.parse("14/10/2021"); //parse serve para facilitar a atribuição de data
        String dataFormatada = formatoData.format(data); //format serve para formatar a data no padrão definido

        System.out.println(dataFormatada);

        Pessoa pessoa = new Pessoa("Flávio", "Malto", "448343964", "Covid", data);

        IVacinacao proxy = new VacinacaoProxy(new VacinacaoService());

        proxy.vacinar(pessoa);
    }

}
