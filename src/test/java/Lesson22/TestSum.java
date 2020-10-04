package Lesson22;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class TestSum {

    MathOperations mathOperations = new MathOperations();
    MathOperations mathOperations1 = null;



    @Test
    public void sumEquals() {
        assertEquals(mathOperations.sum(2,3), 5);
    }

    @Test
    public void sumTrue() {
        assertTrue(mathOperations.sum(2,3)>0);
    }

    @Test
    public void sumFalse() {
        assertFalse(mathOperations.sum(2,3)<0);
    }

    @Test
    public void sameObjects() {
        assertSame(mathOperations, mathOperations);
    }

    @Test
    public void sumThat() {
        assertThat(mathOperations.sum(2,2), is(4));
    }

    @Test
    public void sumNull() {
        assertNull(mathOperations1);
    }

}
