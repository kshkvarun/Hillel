package Lesson22;

import org.junit.Test;

public class UsingAttributes {

    MathOperations mathOperations = new MathOperations();
    MathOperations mathOperations1 = new MathOperations();

    @Test(expected = ArithmeticException.class)
    public void divByZero() {
        int m = mathOperations.dividing(2, 0);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void someAtt() {

        int [] m = new int[10];

        for (int i = -1; i < m.length; i++){
            m[i] = m[i]+1;
        }

    }

    @Test(timeout = 400)
    public void endless() {
        while (true);
    }
}
