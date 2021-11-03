package model;

public enum Tamanho {

    XS ("Extra Pequeno"),
    S ("Pequeno"),
    M ("Médio"),
    L ("Grande"),
    XL ("Extra Grande");

    private String tamanho;
    Tamanho(String tamanho){
        this.tamanho = tamanho;
    }

    public String getTamanho(){
        return tamanho;
    }

}
