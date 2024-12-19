package Payment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PaymentTest {
    @Test
    public void equals() {
        Payment payment = new Payment("Смирнова Дарья", 1, 6, 2020, 100);
        assertEquals(payment, payment);
    }
    @Test
    public void equals1() {
        Payment p1 = new Payment("Смирнова Дарья", 1, 6, 2020, 100);
        Payment p2 = new Payment("Смирнова Дарья", 1, 6, 2020, 100);
        assertEquals(p1, p2);
        assertEquals(p2, p1);
    }
    @Test
    public void equals2() {
        Payment p1 = new Payment("Смирнова Дарья", 1, 6, 2020, 100);
        Payment p2 = new Payment("Смирнова Дарья", 15, 5, 2024, 200);
        assertNotEquals(p1, p2);
    }
    @Test
    public void equals3() {
        Payment p1 = new Payment("Смирнова Дарья", 1, 6, 2020, 100);
        assertNotEquals(p1, null);
    }
    @Test
    public void equalsDifferentFields() {
        Payment p1 = new Payment("Смирнова Дарья", 1, 6, 2023, 100);

        Payment p2 = new Payment("Смирнова Дарья", 1, 6, 2020, 100);
        assertNotEquals(p1, p2);

        p2 = new Payment("Смирнова Дарья", 2, 6, 2020, 100);
        assertNotEquals(p1, p2);

        p2 = new Payment("Смирнова Дарья", 1, 9, 2020, 100);
        assertNotEquals(p1, p2);

        p2 = new Payment("Смирнова Дарья", 1, 6, 2020, 100);
        assertNotEquals(p1, p2);

        p2 = new Payment("Смирнова Дарья", 1, 6, 2020, 111);
        assertNotEquals(p1, p2);
        p2 = new Payment("Смирнова Дарья", 1, 6, 2023, 99);
        assertNotEquals(p1, p2);
    }

    @Test
    public void hashCode1() {
        Payment p1 = new Payment("Смирнова Дарья", 1, 6, 2020, 100);
        Payment p2 = new Payment("Смирнова Дарья", 1, 6, 2020, 100);
        assertEquals(p1.hashCode(), p2.hashCode());
    }
    @Test
    public void hashCodeDifferentObjects() {
        Payment p1 = new Payment("Смирнова Дарья", 1, 6, 2020, 100);
        Payment p2 = new Payment("Смирнов Дарь", 15, 5, 2024, 300);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }
    @Test
    public void hashCodeNullFio() {
        Payment p1 = new Payment(null, 1, 6, 2020, 100);
        Payment p2 = new Payment(null, 1, 6, 2020, 100);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

}
