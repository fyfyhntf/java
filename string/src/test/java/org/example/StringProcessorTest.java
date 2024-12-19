package org.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringProcessorTest {

    @Test
    public void povtorstrok() {
        String s = "s";
        String N = "4";
        String expected = "ssss";
        String actual = StringProcessor.dop(s, N);
        assertEquals(expected, actual);
    }

    @Test
    public void povtorstrok2() {
        String s = "s";
        String N = "-1";
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.dop(s, N);
        });
    }

    @Test
    public void povtorstrok3() {
        String str = "s";
        String N = "0";
        String expected = "";
        String actual = StringProcessor.dop(str, N);
        assertEquals(expected, actual);
    }

    @Test
    public void kolicchestvoVhogdeni() {
        String s1 = "новый год";
        String s2 = "год";
        String expected = "3";
        String actual = String.valueOf(StringProcessor.meted(s1, s2));
        assertEquals(expected, actual);
    }

    @Test
    public void kolicchestvoVhogdeni2() {
        String s1 = "новый год";
        String s2 = "4";
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.meted(s1, s2);
        });
    }

    @Test
    public void kolicchestvoVhogdeni3() {
        String s1 = "новый год";
        String s2 = "null";
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.meted(s1, s2);
        });
    }

    @Test
    public void kolicchestvoVhogdeni4() {
        String s1 = "новый год";
        String s2 = "";
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.meted(s1, s2);
        });
    }

    @Test
    public void str123() {
        String input = "123";
        String expected = "одиндватри";
        String actual = StringProcessor.replaceNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void str123Exception() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.replaceNumbers(input);
        });
    }

    @Test
    public void str123Exception2() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.replaceNumbers(null);
        });
    }

    @Test
    public void str1232() {
        String input = "12345";
        String expected = "одиндватри45";
        String actual = StringProcessor.replaceNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void str1233() {
        String input = "1235";
        String expected = "одиндватри5";
        String actual = StringProcessor.replaceNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void str1234() {
        String input = "23";
        String expected = "дватри";
        String actual = StringProcessor.replaceNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void str1235() {
        String input = "13";
        String expected = "одинтри";
        String actual = StringProcessor.replaceNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void str1236() {
        String input = "12";
        String expected = "одиндва";
        String actual = StringProcessor.replaceNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void str1237() {
        String input = "12345";
        String expected = "одиндватри45";
        String actual = StringProcessor.replaceNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void str1238() {
        String input = "245";
        String expected = "два45";
        String actual = StringProcessor.replaceNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void str1239() {
        String input = "45";
        String expected = "45";
        String actual = StringProcessor.replaceNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void str12310() {
        String input = "1345";
        String expected = "одинтри45";
        String actual = StringProcessor.replaceNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void str12311() {
        String input = "145";
        String expected = "один45";
        String actual = StringProcessor.replaceNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void str12312() {
        String input = "345";
        String expected = "три45";
        String actual = StringProcessor.replaceNumbers(input);
        assertEquals(expected, actual);
    }

    @Test
    public void ydalitvtoroe() {
        StringBuilder s = new StringBuilder("бутылка");
        String expected = "бтла";
        String actual = StringProcessor.ydalitvtoroeInsert(s).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void ydalitvtoroe2() {
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.ydalitvtoroeInsert(new StringBuilder()));
    }

    @Test
        public void ydalitvtoroe3 () {
            assertThrows(IllegalArgumentException.class, () -> StringProcessor.ydalitvtoroeInsert(null));
    }

        @Test
        public void ydalitvtoroe4 () {
            StringBuilder s = new StringBuilder("a");
            StringBuilder result = StringProcessor.ydalitvtoroeInsert(s);
            assertEquals("a", result.toString());
    }
}



