package Arrays;
import Payment.*;
import Payment.Payment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Payment.FinanceReportProcessor.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment("Андреева София", 12, 6, 2024, 12300));
        payments.add(new Payment("Некрасова Ангелина", 18, 9, 2023, 6900));

        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.of(2023, 6, 26);
        String formaDate = date.format(forma);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date reportDate = sdf.parse(formaDate);

        FinanceReport report = new FinanceReport("Смирнова Дарья", reportDate, payments);
        System.out.println(report);


        Payment payment0 = report.getIndexOfPayments(0);
        if (payment0 != null) {
            System.out.println("Платеж: " + payment0.getFio() + ", сумма: " + payment0.getSum());
        } else {
            System.out.println("Платеж с таким индексом не найден.");
        }

        Date reportDate1 = new Date();

        FinanceReport report1 = new FinanceReport("Петров Иван Васильевич", reportDate1, payments);

        System.out.println("Количество платежей: " + report1.getPayments());

        FinanceReport nameBeginsWithLetter = nameBeginsWithLetter(report1, payments, 'A');
        System.out.println("\nПервая буква Фамилии 'A':\n" + nameBeginsWithLetter);

        FinanceReport smallerPayments = valuePayments(report1, payments, 15000);
        System.out.println("\nПлатежи, у которых сумма меньше 15000:\n" + smallerPayments);
    }
}