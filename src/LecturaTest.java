import static org.junit.Assert.assertEquals;

import java.beans.Transient;

import org.junit.Test;

public class LecturaTest {


    @Test 
    public void TestLectura(){
        assertEquals(" 12*3^", Lectura.In2Post("(1*2)^3"));
    }

    

}
}
