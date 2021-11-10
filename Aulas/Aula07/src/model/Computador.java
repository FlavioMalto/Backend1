package model;

public class Computador {

    private Integer ram;
    private Integer hd;
    private static Integer contador = 0;  //static só se usa a variável dentro da classe.

    public Computador(Integer ram, Integer hd) {
        this.ram = ram;
        this.hd = hd;
        contador++; //toda vez que for usado o método contrutor para um computador o contador somará 1.
        System.out.println("Contador: " + contador);
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getHd() {
        return hd;
    }

    public void setHd(Integer hd) {
        this.hd = hd;
    }

    @Override
    public String toString() {
        return "Computador{" +
                "ram=" + ram +
                ", hd=" + hd +
                '}';
    }
}
