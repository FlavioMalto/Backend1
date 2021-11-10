import model.Computador;

public class Main {

    public static void main(String[] args) {

        ComputadorFactory factory = new ComputadorFactory();
        Computador cpu1 = factory.buscarComputador(8, 500);
        Computador cpu2 = factory.buscarComputador(16, 120);

        System.out.println(cpu1.toString());
        System.out.println(cpu2.toString());

    }

}
