package ExercicioJUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PessoaTest {

    Pessoa pessoa1;
    Pessoa pessoa2;
    Pessoa pessoa3;

    @BeforeEach //executa uma ação antes de cada teste.
    void doBefore(){
        pessoa1 = new Pessoa("Flávio", "Malto");
        pessoa1.setIdade(LocalDate.of(1989, 1, 27));

        pessoa2 = new Pessoa("Helena", "Martinez");
        pessoa2.setIdade(LocalDate.of(1990, 11, 12));

        pessoa3 = new Pessoa("Matheus", "Affonso");
        pessoa3.setIdade(LocalDate.of(1987, 11, 12));
    }

    @Test
    void getNomeCompleto(){
        Assertions.assertEquals("Flávio Malto", pessoa1.formarNomeCompleto());
    }

    @Test
    void getEMaior18(){
        Assertions.assertEquals(true, pessoa1.eMaiorDeIdade());
    }

}
