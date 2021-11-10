package model;

public class Roupa {

    private Tamanho tamanho;
    private TipoRoupa tipo;
    private Boolean isNew;
    private Boolean importado;

    public Roupa(Tamanho tamanho, TipoRoupa tipo, Boolean isNew, Boolean importado) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.isNew = isNew;
        this.importado = importado;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public TipoRoupa getTipo() {
        return tipo;
    }

    public void setTipo(TipoRoupa tipo) {
        this.tipo = tipo;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getImportado() {
        return importado;
    }

    public void setImportado(Boolean importado) {
        this.importado = importado;
    }
}
