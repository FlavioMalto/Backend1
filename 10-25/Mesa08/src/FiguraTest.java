import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FiguraTest {

    @Test
    void testaQuadrado(){
        Figura quadradro = new Quadrado(4);
        double resultado = quadradro.calcularPerimetro();
        Assertions.assertEquals(16, resultado);
    }

    @Test
    void testaCirculo(){
        Figura circulo = new Circulo(4);
        double resultado = circulo.calcularPerimetro();
        Assertions.assertEquals(2 * Math.PI * 4, resultado);
    }

}
