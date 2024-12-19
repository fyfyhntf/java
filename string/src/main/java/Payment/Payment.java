package Payment;

import java.util.Objects;

public class Payment {
        private String fio;
        private int day;
        private int month;
        private int year;
        private int sum;

        public Payment(String fio, int data, int month, int year, int sum) {
            this.fio = fio;
            this.day = data;
            this.month = month;
            this.year = year;
            this.sum = sum;
        }

        public String getFio() {
            return fio;
        }

        public int getDay() {
            return day;
        }

        public int getMonth() {
            return month;
        }

        public int getYear() {
            return year;
        }

        public int getSum() {
            return sum;
        }

        public void setFio(String fio) {
            if (fio == null || fio.trim().isEmpty()) {
                throw new IllegalArgumentException("ФИО не должно быть пустым");
            }
            this.fio = fio;
        }

        public void setDay(int day) {
            if (day <= 0 || day > 31) {
                throw new IllegalArgumentException("День должен быть в диапазоне от 1 до 31");
            }
            this.day = day;
        }

        public void setMonth(int month) {
            if (month <= 0 || month > 12) {
                throw new IllegalArgumentException("Месяц должен быть в диапазоне от 1 до 12");
            }
            this.month = month;
        }

        public void setYear(int year) {
            if (year <= 0) {
                throw new IllegalArgumentException("Год не может быть отрицательным или нулевым");
            }
            this.year = year;
        }

        public void setSum(int sum) {
            if (sum < 0) {
                throw new IllegalArgumentException("Сумма не может быть отрицательной");
            }
            this.sum = sum;    }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Payment payment = (Payment) o;
            return day == payment.day && month == payment.month && year == payment.year && sum == payment.sum && Objects.equals(fio, payment.fio);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fio, day, month, year, sum);
        }

        @Override
        public String toString() {
            return "Payment{" +
                    "FIO='" + fio + '\'' +
                    ", data=" + day +
                    ", month=" + month +
                    ", year=" + year +
                    ", sum=" + sum +
                    '}';
        }
    }

