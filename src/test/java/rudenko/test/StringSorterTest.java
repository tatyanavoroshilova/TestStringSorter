package rudenko.test;

import org.junit.Test;
import rudenko.testtask.StringSorter;

import static org.junit.Assert.assertEquals;

public class StringSorterTest {
    private static final String s = "сапог сарай арбуз болт бокс биржа";

    @Test
    public void shouldReturnResults() {
        StringSorter stringSorter = new StringSorter();
        String expected = "[б=[биржа, бокс, болт], с=[сапог, сарай]]";
        assertEquals(stringSorter.getSortedString(s), expected);
    }

    @Test
    public void shouldReturnEmptyRes() {
        StringSorter stringSorter = new StringSorter();
        String expected = "";
        assertEquals(stringSorter.getSortedString(""), expected);
    }
}