import model.Roupa;
import model.Tamanho;
import model.TipoRoupa;

import java.util.HashMap;
import java.util.Map;

public class FabricaRoupa {

    private static Map<String, Roupa> flyweight = new HashMap<>();

    private static Integer contador = 0;

    public Roupa fabricarRoupa(Tamanho tamanho, TipoRoupa tipo, Boolean isNew, Boolean importado){

        String id = "TipoRoupa:" + tipo;

        if(!flyweight.containsKey(id)){
            flyweight.put(id, new Roupa(tamanho, tipo, isNew, importado));
            System.out.println("Roupa fabricada!");
        }

        contador++;

        return flyweight.get(id);

    }

    //quando é criado um objeto roupa ele é armazenado no HashMap
    public int getFlyweightSize(){
        return flyweight.size();
    }

    public static Integer getContador(){
        return contador;
    }

}
