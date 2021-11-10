import model.Afiliado;
import model.Funcionario;

public class Main {

    public static void main(String[] args) {

        Funcionario flavio = new Funcionario("Flavio Malto", 15);

        Afiliado alice = new Afiliado("Alice", 1);
        Afiliado mirela = new Afiliado("Mirela", 2);
        Afiliado pedro = new Afiliado("Pedro", 3);

        flavio.obterAfiliado(alice);
        flavio.obterAfiliado(mirela);
        flavio.obterAfiliado(pedro);

        flavio.vender();
        flavio.vender();
        flavio.vender();
        flavio.vender();
        flavio.vender();
        flavio.vender();
        flavio.vender();
        flavio.vender();

        System.out.println(flavio.getNome() +" tem um total de "+ flavio.getPontos()+ " pontos e categoriza como vendedor " + flavio.mostrarCategoria());
        System.out.println(alice.getNome() + " tem um total de " + alice.getPontos()+ " pontos e categoriza como afiliado "+ alice.mostrarCategoria());

    }

}
