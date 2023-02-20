import static org.junit.Assert.assertEquals;

import java.beans.Transient;

import org.junit.Test;

public class CalculadoraTest {
    Calculadora miCalculadora = Calculadora.getInstance();

    @Test
    public void Testsumar() {
        assertEquals(miCalculadora.Calcular("12+",1),3);
    }

    @Test 
    public void Testrestar() {
        assertEquals(miCalculadora.Calcular("89-",2), -1);
    }

    @Test
    public void Testmultiplicar() {
        assertEquals(miCalculadora.Calcular("57*", 1), 35);
    }

    @Test
    public void Testdividir() {
        assertEquals(miCalculadora.Calcular("82/", 1), 4);
    }

    @Test 
    public void Testexponente() {
        assertEquals(miCalculadora.Calcular("23^", 1), 8);
    }
}
