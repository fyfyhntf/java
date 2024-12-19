package Payment;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class FinanceReportTest {

    @Test
    public void getIndexOfPayments() {
        List<Payment> payments = List.of(
                new Payment("Егорова Яна Денисовна", 26, 6, 2023, 5600),
                new Payment("Сотникова Анастасия Владимировна", 6, 11, 2023, 10000),
                new Payment("Сотников Никита Сергеевич", 9, 9, 2023, 8900),
                new Payment("Стёпин Филипп Алексеевич", 6, 1, 2023, 160)
        );
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        Payment expectedPayment = report.getIndexOfPayments(2);
        assertEquals(expectedPayment, report.getIndexOfPayments(2));
    }

    @Test
    public void getIndexOfPaymentException() {
        List<Payment> payments = List.of(
                new Payment("Егорова Яна Денисовна", 26, 6, 2023, 5600),
                new Payment("Сотникова Анастасия Владимировна", 6, 11, 2023, 10000),
                new Payment("Сотников Никита Сергеевич", 9, 9, 2023, 8900),
                new Payment("Стёпин Филипп Алексеевич", 6, 1, 2023, 160)
        );
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            report.getIndexOfPayments(-2);
        });
    }

    @Test
    public void getIndexOfPaymentException1() {
        List<Payment> payments = List.of(
                new Payment("Егорова Яна Денисовна", 26, 6, 2023, 5600),
                new Payment("Сотникова Анастасия Владимировна", 6, 11, 2023, 10000),
                new Payment("Сотников Никита Сергеевич", 9, 9, 2023, 8900),
                new Payment("Стёпин Филипп Алексеевич", 6, 1, 2023, 160)
        );
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            report.getIndexOfPayments(5);
        });
    }

    @Test
    public void setPaymentIndex() {
        List<Payment> payments = new ArrayList<>(List.of(
                new Payment("Test 1", 1, 1, 2024, 1000)
        ));
        Payment newPayment = new Payment("Сотникова Анастасия Владимировна", 6, 11, 2023, 10000);
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        report.setPaymentIndex(0, newPayment);
        assertEquals(newPayment, report.getIndexOfPayments(0));
    }

    @Test
    public void setIndexOfPaymentsException() {
        List<Payment> payments = new ArrayList<>(List.of(
                new Payment("Test 1", 1, 1, 2024, 1000)
        ));
        Payment newPayment = new Payment("Сотникова Анастасия Владимировна", 6, 11, 2023, 10000);
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            report.setPaymentIndex(-1, newPayment);
        });
    }

    @Test
    public void setIndexOfPaymentsException1() {
        List<Payment> payments = new ArrayList<>(List.of(
                new Payment("Test 1", 1, 1, 2024, 1000)
        ));
        Payment newPayment = new Payment("Сотникова Анастасия Владимировна", 6, 11, 2023, 10000);
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            report.setPaymentIndex(3, newPayment);
        });
    }
}