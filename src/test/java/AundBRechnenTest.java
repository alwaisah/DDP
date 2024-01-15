import org.junit.Test;

import static org.junit.Assert.*;

public class AundBRechnenTest {
    @Test
    public void addierenTests() {
        AundBRechnen aundBRechnenTest = new AundBRechnen();
        long resalt = aundBRechnenTest.addieren(1, 2);
        assertEquals(3, resalt);
    }
}