package model;

public abstract class Vendedor {

    private String nome;
    private int pontos;
    private int tempoEmpresa;

    public Vendedor(String nome, int tempoEmpresa) {
        this.nome = nome;
        this.tempoEmpresa = tempoEmpresa;
        this.pontos += tempoEmpresa * 5;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos += pontos;
    }

    public int getTempoEmpresa() {
        return tempoEmpresa;
    }

    public void setTempoEmpresa(int tempoEmpresa) {
        this.tempoEmpresa = tempoEmpresa;
    }

    public String mostrarCategoria(){
        if(this.getPontos() < 20 ) {
            return VendedorCategoria.NOVATO.getDescricao();
        } else if(this.getPontos() >= 20 && this.getPontos() <= 30) {
            return VendedorCategoria.APRENDIZ.getDescricao();
        } else if(this.getPontos() >= 31 && this.getPontos() <= 40) {
            return VendedorCategoria.BOM.getDescricao();
        } else {
            return VendedorCategoria.MESTRE.getDescricao();
        }
    }

    public abstract void vender();

    public String mostrarCategoriaEstagiario(){
        if(this.getPontos() < 50) {
            return EstagiarioCategoria.ESTAGIARIO_NOVO.getDescricao();
        } else {
            return EstagiarioCategoria.ESTAGIARIO_ANTIGO.getDescricao();
        }
    }

}
