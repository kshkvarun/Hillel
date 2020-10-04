package Lesson22;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TestMultiplying {
    MathOperations mathOperations = new MathOperations();
    MathOperations mathOperations1 = new MathOperations();


    @Test
    public void mulEquals() {
        assertEquals(mathOperations.multiplying(2 , 2), 4);
    }

    @Test
    public void mulTrue() {
        assertTrue(mathOperations.multiplying(2,3)<0);
    }

    @Test
    public void mulFalse() {
        assertFalse(mathOperations.multiplying(2,3)>0);
    }

    @Test
    public void mulObjectsSame() {
        assertSame(mathOperations, mathOperations);
    }

    @Test
    public void mulObjectsNotSame() {
        assertNotSame(mathOperations, mathOperations1);
    }


    @Test
    public void mulThat() {
        assertThat(mathOperations.multiplying(6,3), is(18));
    }

    @Test
    public void mulNull() {
        assertNull(mathOperations);
    }
}
