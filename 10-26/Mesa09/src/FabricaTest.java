import model.Roupa;
import model.Tamanho;
import model.TipoRoupa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FabricaTest {

    FabricaRoupa fabricaRoupa = new FabricaRoupa();

    Roupa roupa1 = fabricaRoupa.fabricarRoupa(Tamanho.XL, TipoRoupa.CALCA, true, true);
    Roupa roupa2 = fabricaRoupa.fabricarRoupa(Tamanho.L, TipoRoupa.CALCA, true, true);
    Roupa roupa3 = fabricaRoupa.fabricarRoupa(Tamanho.M, TipoRoupa.CALCA, true, false);
    Roupa roupa4 = fabricaRoupa.fabricarRoupa(Tamanho.S, TipoRoupa.CAMISA, false, true);
    Roupa roupa5 = fabricaRoupa.fabricarRoupa(Tamanho.XS, TipoRoupa.CAMISA, true, false);

    @Test
    void ProductionTest(){
        Assertions.assertEquals(Tamanho.XL, roupa1.getTamanho());
        Assertions.assertEquals(TipoRoupa.CALCA, roupa1.getTipo());
        Assertions.assertTrue(roupa1.getNew());
        Assertions.assertTrue(roupa1.getImportado());
    }

    @Test
    void ProductionTest2(){
        Assertions.assertTrue(roupa2.getTamanho() == Tamanho.XL
                && roupa2.getTipo() == TipoRoupa.CALCA
                && roupa2.getNew() == true
                && roupa2.getImportado() == true);
    }

    @Test
    void TestandoTamanho(){
        Assertions.assertTrue(FabricaRoupa.getContador() > fabricaRoupa.getFlyweightSize());
    }


}
