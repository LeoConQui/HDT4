import static org.junit.Assert.assertEquals;

import java.beans.Transient;

import org.junit.Test;

public class StackFactoryTest {
    
    StackFactory factory = new StackFactory<Integer>();

    @Test
    public void TestStackUsingArrayList() {
        assertEquals(factory.InstanceCreator(1).getClass(), StackUsingArrayList.class);
    }

    @Test 
    public void TestStackUsingVector() {
        assertEquals(factory.InstanceCreator(2).getClass(), StackUsingVector.class);
    }    
}
