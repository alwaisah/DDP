import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GetraenkFlascheTest {

    @Test
    public void getName() {
        GetraenkFlasche testFlasche = new GetraenkFlasche("Rotwein", BigDecimal.valueOf(5));
        assertEquals("Rotwein", testFlasche.getName());
    }

    @Test
    public void setName() {
    }

    @Test
    public void getPreis() {
        BigDecimal bigDecimal = BigDecimal.valueOf(5);
        GetraenkFlasche testFlasche = new GetraenkFlasche("Rotwein", BigDecimal.valueOf(5));
//
        assertEquals(BigDecimal.valueOf(5), testFlasche.getPreis());

    }

    @Test
    public void setPreis() {
    }
}