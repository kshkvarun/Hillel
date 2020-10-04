package Lesson22;

import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.core.CombinableMatcher.either;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

interface stringTest{
}

public class TestWithStrings {

    Strings string = new Strings();
    Strings string1 = new Strings();
    Strings string2 = null;

    @BeforeClass
    public static void print() {
        System.out.println("\"BeforeClass annotation\" is using to do something before all tests in class ");
    }

    @AfterClass
    public static void print1() {
        System.out.println("\"AfterClass annotation\" is using to do something before all tests in class \"");
    }


    @Test
    public void stringEquals() {
        assertEquals(string.concatStrings("Some", "word"), string1.concatStrings("Some", "word"));
        Assume.assumeThat("Someword is...", "Someword", is(equals(string.concatStrings("Some", "word"))));
    }

    @Test
    public void stringTrue() {
        assertTrue(string.concatStrings("Some", "word").equals("Someword"));
    }

    @Category(stringTest.class)
    @Test
    public void stringObjectSame() {
        assertThat(string.concatStrings("Some", "word"), either(containsString("so")).or(containsString("wo")));
    }

    @Test
    public void stringSame() {
        assertSame(string.concatStrings("Some", "word"), string1.concatStrings("Some", "word"));
    }

    @Test
    public void stringSame1() {
        assertSame(string1.concatStrings("Some", "word"), string1.concatStrings("Some", "word"));
    }
    @Test
    public void stringNull() {
        assertNull(string.concatStrings("Some", "word"));
        Assume.assumeNotNull(string1);
    }



}
