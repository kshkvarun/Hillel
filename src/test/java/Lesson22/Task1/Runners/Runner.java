package Lesson22.Task1.Runners;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Runner {

    @RunWith(value = Parameterized.class)
    public static class ParameterizedTest1 {

        private int numberA;
        private int numberB;
        private int expected;

        public ParameterizedTest1(int numberA, int numberB, int expected) {
            this.numberA = numberA;
            this.numberB = numberB;
            this.expected = expected;
        }

        @Parameterized.Parameters(name = "{index}: testAdd({0}+{1}) = {2}")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {1, 1, 2},
                    {2, 2, 4},
                    {8, 2, 10},
                    {4, 5, 9},
                    {5, 5, 10}
            });
        }

        @Test
        public void comparing() {
            assertThat((numberA + numberB), is(expected));
        }
    }
}
