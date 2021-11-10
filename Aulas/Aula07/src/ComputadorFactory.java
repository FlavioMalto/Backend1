import model.Computador;

import java.util.HashMap;
import java.util.Map;

public class ComputadorFactory {

    // string armazena o ID e é referente ao objeto computador
    private static Map<String, Computador> flyweith = new HashMap<>();

    //método para verificar se já existe uma instância Computador
    public Computador buscarComputador(Integer ram, Integer hd){

        String id = "ram:" + ram + "hd:" + hd;

        // containsKey e get são métodos do Map (!) condição negativa
        if(!flyweith.containsKey(id)){
            flyweith.put(id, new Computador(ram, hd)); //coloca o id em um novo computador na variável map flyweith.
            System.out.println("Computador Criado!");
        }else{
            System.out.println("Computador já existe!");
        }

        return flyweith.get(id);

    }

}
