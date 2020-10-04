package Lesson22;

import org.junit.Test;

import static org.hamcrest.core.CombinableMatcher.either;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;


public class TestWithStrings {

    Strings string = new Strings();
    Strings string1 = new Strings();

    @Test
    public void stringEquals() {
        assertEquals(string.concatStrings("Some", "word"), string1.concatStrings("Some", "word"));
    }

    @Test
    public void stringTrue() {
        assertTrue(string.concatStrings("Some", "word").equals("Someword"));
    }

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
        assertSame(string1.concatStrings("Some", "word").toCharArray(), string1.concatStrings("Some", "word").toCharArray());
    }
    @Test
    public void stringNull() {
        assertNull(string.concatStrings("Some", "word"));
    }



}
