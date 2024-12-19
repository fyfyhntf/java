package Payment;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class FinanceReportProcessorTest {

    @Test
    public void nameBeginsWithLetter1() {
        List<Payment> payments1 = List.of(
                new Payment("Егорова Яна Денисовна", 26, 6, 2023, 5600),
                new Payment("Сотникова Анастасия Владимировна", 6, 11, 2023, 10000),
                new Payment("Сотников Никита Сергеевич", 9, 9, 2023, 8900),
                new Payment("Стёпин Филипп Алексеевич", 6, 1, 2023, 160)
        );
        List<Payment> payments = List.of(
        );
        FinanceReport report1 = new  FinanceReport("Озонов Михаил Иванович", new Date(), payments);
        FinanceReport report2 = new  FinanceReport("Озонов Михаил Иванович", new Date(), payments1);
        assertEquals(report1, FinanceReportProcessor.nameBeginsWithLetter(report2, payments1, ' '));
    }


    @Test
    public void valuePayments1() {
        List<Payment> payments = List.of(
                new Payment("Егорова Яна Денисовна", 26, 6, 2023, 5600),
                new Payment("Сотникова Анастасия Владимировна", 6, 11, 2023, 10000),
                new Payment("Сотников Никита Сергеевич", 9, 9, 2023, 8900),
                new Payment("Стёпин Филипп Алексеевич", 6, 1, 2023, 160)
        );
        Date date = new Date();
        FinanceReport fr1 = new FinanceReport("Озонов Михаил Иванович", date, payments);
        List<Payment> expectedPayments = List.of(
        );
        FinanceReport expected = new FinanceReport("Озонов Михаил Иванович", date, expectedPayments);
        FinanceReport filtered = FinanceReportProcessor.valuePayments(fr1, payments, ' ');
        assertEquals(expected, filtered);
    }
    @Test
    public void valuePayments2() {
        List<Payment> payments = List.of(
                new Payment("Егорова Яна Денисовна", 26, 6, 2023, 5600),
                new Payment("Сотникова Анастасия Владимировна", 6, 11, 2023, 10000),
                new Payment("Сотников Никита Сергеевич", 9, 9, 2023, 8900),
                new Payment("Стёпин Филипп Алексеевич", 6, 1, 2023, 160)
        );
        Date date = new Date();
        FinanceReport report = new FinanceReport("Озонов Михаил Иванович", date, payments);
        assertThrows(IllegalArgumentException.class, () -> {
            FinanceReportProcessor.valuePayments(report, payments, -10);
        });
    }
}
