package model;

public enum VendedorCategoria {

    NOVATO("novato"),
    APRENDIZ("aprendiz"),
    BOM("bom"),
    MESTRE("mestre");

    private String descricao;

    VendedorCategoria(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}
