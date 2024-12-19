package org.example;

import java.util.Scanner;

public class StringProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задания:");
        int numerZ = scanner.nextInt();
        switch (numerZ) {
            case 1:
                povtorstrok();
                break;
            case 2:
                kolicchestvoVhogdeni();
                break;
            case 3:
                str123();
                break;
            case 4:
                ydalitvtoroe();
                break;
        }
    }

    public static void povtorstrok() {
        System.out.println("Вы запустили первое задание");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str = scanner.nextLine();
        System.out.println("Введите число:");
        String N = scanner.nextLine();
        try {
            String result = dop(str, N);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static String dop(String s, String N) {
        int n = Integer.parseInt(N);
        if (n == 0) {
            return "";
        }
        if (n < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным.");
        }
        return String.valueOf(s).repeat(n);
    }


    public static void kolicchestvoVhogdeni() {
        System.out.println("Вы запустили второе задание");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строку:");
        String s1 = scanner.nextLine();
        System.out.println("Введите вторую строку:");
        String s2 = scanner.nextLine();
        try {
            int s = meted(s1, s2);
            System.out.println(s);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static int meted(String s1, String s2) {

        if ((s2 == null) || s2.isEmpty()) {
            throw new IllegalArgumentException("Строка не может быть пустой или null.");
        }
        if (!s1.contains(s2)) {
            throw new IllegalArgumentException("Ошибка");
        }
        return s1.length() - s1.replace(String.valueOf(s2), "").length();
    }

    public static void str123() {
        System.out.println("Вы запустили третье задание");
        String inputString = "123";
        String a = replaceNumbers(inputString);
        System.out.println("Исходная строка: " + inputString);
        System.out.println("Новая строка: " + a);
    }

    static String replaceNumbers(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Строка не может быть пустой");
        }
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char zamena = input.charAt(i);
            switch (zamena) {
                case '1':
                    b.append("один");
                    break;
                case '2':
                    b.append("два");
                    break;
                case '3':
                    b.append("три");
                    break;
                default:
                    b.append(zamena);
            }
        }
        return b.toString();
    }

    public static void ydalitvtoroe() {
        StringBuilder s;
        System.out.println("Вы запустили четвертое задание");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        s = new StringBuilder(scanner.nextLine());
        String result = String.valueOf(ydalitvtoroeInsert(s));
        System.out.print("Результат: " + result);
    }
    public static StringBuilder ydalitvtoroeInsert(StringBuilder s){
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Строка не может быть пустой");
        }
        int index = 1;
        while (index < s.length()) {
            s.deleteCharAt(index);
            index += 1;
        }
        return s;
    }
}
