package model;

public class Estagiario extends Vendedor{

    public Estagiario(String nome, int tempoEmpresa) {
        super(nome, tempoEmpresa);
    }

    @Override
    public void vender() {
        this.setPontos(5);
    }

}
