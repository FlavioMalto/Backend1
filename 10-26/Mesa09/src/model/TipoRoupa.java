package model;

public enum TipoRoupa {

    CALCA ("Calça"),
    CAMISA ("Camisa");

    private String descricao;

    TipoRoupa(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

}
