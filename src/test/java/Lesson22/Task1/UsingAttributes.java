package Lesson22.Task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UsingAttributes {

    MathOperations mathOperations = new MathOperations();


    @Before
    public void print2() {
        System.out.println("\"Before annotation\" is using to do something before each test in class");
    }

    @After
    public void print3() {
        System.out.println("\"After annotation\" is using to do something after each test in class");
    }

    @Test(expected = ArithmeticException.class)
    public void divByZero() {
        int m = mathOperations.dividing(2, 0);
        System.out.println(m);
    }




    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void someAtt() {

        int [] m = new int[10];

        for (int i = -1; i < m.length; i++){
            m[i] = m[i]+1;
        }
        System.out.println(m);

    }

    @Test(timeout = 400)
    public void endless() {
        while (true);
    }

}
