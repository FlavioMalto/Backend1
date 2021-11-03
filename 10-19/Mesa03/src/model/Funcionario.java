package model;

public class Funcionario extends Vendedor{

    public Funcionario(String nome, int tempoEmpresa) {
        super(nome, tempoEmpresa);
    }

    @Override
    public void vender() {
        this.setPontos(5);
    }
    public void obterAfiliado(Afiliado nome){
        this.setPontos(10);
    }

}
