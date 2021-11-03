package model;

public class Afiliado extends Vendedor{

    public Afiliado(String nome, int tempoEmpresa) {
        super(nome, tempoEmpresa);
    }

    @Override
    public void vender() {
        this.setPontos(15);
    }

}
