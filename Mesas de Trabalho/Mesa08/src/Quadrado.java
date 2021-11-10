public class Quadrado extends Figura{

    private double comprimento;

    public Quadrado(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * comprimento;
    }
}
