package Lesson22;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

interface divTest{
}


public class TestDeviding {
    MathOperations mathOperations = new MathOperations();
    MathOperations mathOperations1 = new MathOperations();
    MathOperations mathOperations2 = null;

    @Category(divTest.class)
    @Test
    public void divEquals() {
        assertEquals(mathOperations.dividing(6.4 , 2.0), 3.2, 0.0);
    }

    @Test
    public void divTrue() {
        assertTrue(mathOperations.dividing(2,3)>0);
    }



    @Test
    public void divFalse() {
        assertFalse(mathOperations.dividing(2,3)<0);
    }

    @Test
    public void divObjectsSame() {
        assertSame(mathOperations, mathOperations1);
    }

    @Test
    public void divObjectsNotSame() {
        assertNotSame(mathOperations, mathOperations1);
    }


    @Test
    public void divThat() {
        assertThat(mathOperations.dividing(6,3), is(2));
    }

    @Test
    public void divNull() {
        assertNull(mathOperations2);
    }

}