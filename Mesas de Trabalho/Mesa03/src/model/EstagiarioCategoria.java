package model;

public enum EstagiarioCategoria {

    ESTAGIARIO_NOVO("Estágiario inexperiente"),
    ESTAGIARIO_ANTIGO("Estágiario experiente");

    private String descricao;

    EstagiarioCategoria(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}
