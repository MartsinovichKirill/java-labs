package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите задание (1-4):");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                String str = "      Кис,кис, мяу, мяу      ";
                String str1 = str.trim();
                System.out.println(str1);
                break;
            case 2:
                String s = "Кис,кис,мяу,амяу";
                char target = 'а';

                int[] mas = new int[s.length()];
                int count = 0;

                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == target) {
                        mas[count++] = i;
                    }
                }

                for (int i = 0; i < count; i++) {
                    System.out.print(mas[i] + " ");
                }
                System.out.println();
                break;
            case 3:
                Employee[] employees = {
                        new Employee("Иванов", 45000.5),
                        new Employee("Петрова", 62000.0),
                        new Employee("Сидоров", 38750.75),
                        new Employee("Кузнецова", 91200.123),
                };
                Report.generateReport(employees);
                break;
            case 4:
                String str3 = "'apple ap-ple ap_ple ap ple ap1rple aplle'";
                Pattern pattern = Pattern.compile("ap+.[^{Blank} ]{0}+le");
                Matcher matcher = pattern.matcher(str3);

                while (matcher.find()) {
                    System.out.println(matcher.group());
                }
                break;
            default:
                System.out.println("Такого задания нет.");
        }
    }
}
