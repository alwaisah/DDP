import org.junit.Test;

import static org.junit.Assert.*;

public class GetraenkFlascheTest {

    @Test
    public void getName() {
        GetraenkFlasche testFlasche = new GetraenkFlasche("Rotwein", 2.5);
        assertEquals("Rotwein", testFlasche.getName());
    }

    @Test
    public void setName() {
    }

    @Test
    public void getPreis() {
    }

    @Test
    public void setPreis() {
    }
}