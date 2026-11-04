package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Проверка, является ли число полным квадратом (для Задания 2)
    private static boolean isPerfectSquare(int n) {
        if (n < 0) {
            return false;
        }
        int root = (int) Math.round(Math.sqrt(n));
        return root * root == n;
    }

    // Задание 1: Создать файл с информацией о своём питомце. Вывести данные об этом файле и информацию из файла.
    public static void task1() {
        System.out.println("\n=== ЗАДАНИЕ 1: Информация о питомце ===");
        File petFile = new File("pet_info.txt");

        try (PrintWriter writer = new PrintWriter(new FileWriter(petFile, StandardCharsets.UTF_8))) {
            writer.println("Имя питомца: Барсик");
            writer.println("Вид: Кот");
            writer.println("Порода: Британская короткошёрстная");
            writer.println("Возраст: 3 года");
            writer.println("Любимое занятие: Спать на подоконнике и играть с мячиком");
        } catch (IOException e) {
            System.out.println("Ошибка записи файла: " + e.getMessage());
            return;
        }

        System.out.println("--- Свойства файла ---");
        System.out.println("Имя файла: " + petFile.getName());
        System.out.println("Размер файла: " + petFile.length() + " байт");
        System.out.println("Последняя модификация: " + petFile.lastModified());
        System.out.println("Родительский каталог: " + petFile.getParent());
        System.out.println("Путь: " + petFile.getPath());
        System.out.println("Абсолютный путь: " + petFile.getAbsolutePath());
        System.out.println("Файл " + (petFile.exists() ? "существует" : "не существует"));
        System.out.println(petFile.canRead() ? "Разрешено чтение" : "Чтение запрещено");
        System.out.println(petFile.canWrite() ? "Разрешена запись" : "Запись запрещена");
        System.out.println("Это " + (petFile.isDirectory() ? "каталог" : "не каталог"));
        System.out.println("Это " + (petFile.isFile() ? "обычный файл" : "не обычный файл"));

        System.out.println("\n--- Содержимое файла ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(petFile, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    // Задание 2: Ввести с клавиатуры в файл f 10 целых чисел. Вывести их на экран и найти количество полных квадратов.
    public static void task2(Scanner console) {
        System.out.println("\n=== ЗАДАНИЕ 2: 10 целых чисел и количество полных квадратов ===");
        File fileF = new File("f_task2.txt");

        System.out.println("Введите 10 целых чисел:");
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileF, StandardCharsets.UTF_8))) {
            for (int i = 0; i < 10; i++) {
                System.out.print("Число " + (i + 1) + ": ");
                int num = console.nextInt();
                writer.println(num);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл f: " + e.getMessage());
            return;
        }

        int squareCount = 0;
        System.out.print("Считанные числа из файла f: ");
        try (Scanner fileScanner = new Scanner(fileF, StandardCharsets.UTF_8)) {
            while (fileScanner.hasNextInt()) {
                int num = fileScanner.nextInt();
                System.out.print(num + " ");
                if (isPerfectSquare(num)) {
                    squareCount++;
                }
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла f: " + e.getMessage());
            return;
        }

        System.out.println("Количество чисел, являющихся полными квадратами: " + squareCount);
    }

    // Задание 3: Создать текстовый файл f со случайными целыми числами.
    // Записать в файл g все числа, оканчивающиеся на чётную цифру, а в файл h – все остальные.
    public static void task3() {
        System.out.println("\n=== ЗАДАНИЕ 3: Распределение случайных чисел по файлам g и h ===");
        File fileF = new File("f_task3.txt");
        File fileG = new File("g_task3.txt");
        File fileH = new File("h_task3.txt");
        Random random = new Random();

        try (PrintWriter writerF = new PrintWriter(new FileWriter(fileF, StandardCharsets.UTF_8))) {
            for (int i = 0; i < 15; i++) {
                int randomNum = random.nextInt(201) - 100; // от -100 до 100
                writerF.println(randomNum);
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания файла f: " + e.getMessage());
            return;
        }

        try (Scanner scannerF = new Scanner(fileF, StandardCharsets.UTF_8);
             PrintWriter writerG = new PrintWriter(new FileWriter(fileG, StandardCharsets.UTF_8));
             PrintWriter writerH = new PrintWriter(new FileWriter(fileH, StandardCharsets.UTF_8))) {

            System.out.print("Числа в исходном файле f: ");
            while (scannerF.hasNextInt()) {
                int num = scannerF.nextInt();
                System.out.print(num + " ");
                int lastDigit = Math.abs(num % 10);
                if (lastDigit % 2 == 0) {
                    writerG.println(num);
                } else {
                    writerH.println(num);
                }
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка обработки файлов: " + e.getMessage());
            return;
        }

        System.out.print("Файл g (оканчиваются на чётную цифру): ");
        printFileNumbers(fileG);
        System.out.print("Файл h (все остальные): ");
        printFileNumbers(fileH);
    }

    private static void printFileNumbers(File file) {
        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8)) {
            while (sc.hasNextInt()) {
                System.out.print(sc.nextInt() + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла " + file.getName() + ": " + e.getMessage());
        }
    }

    // Задание 4: Ввести с клавиатуры в файл 15 вещественных значений частоты. Считать данные и вывести среднюю частоту.
    public static void task4(Scanner console) {
        System.out.println("\n=== ЗАДАНИЕ 4: 15 вещественных значений частоты и средняя частота ===");
        File freqFile = new File("frequencies.txt");

        System.out.println("Введите 15 вещественных значений частоты:");
        try (PrintWriter writer = new PrintWriter(new FileWriter(freqFile, StandardCharsets.UTF_8))) {
            for (int i = 0; i < 15; i++) {
                System.out.print("Частота " + (i + 1) + ": ");
                double freq = console.nextDouble();
                writer.println(freq);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи файла частот: " + e.getMessage());
            return;
        }

        double sum = 0.0;
        int count = 0;
        try (Scanner fileScanner = new Scanner(freqFile, StandardCharsets.UTF_8)) {
            while (fileScanner.hasNext()) {
                String token = fileScanner.next().replace(',', '.');
                double val = Double.parseDouble(token);
                sum += val;
                count++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла частот: " + e.getMessage());
            return;
        }

        double average = (count > 0) ? (sum / count) : 0.0;
        System.out.printf("Средняя частота (%d измерений): %.2f Гц%n", count, average);
    }

    // Задание 5: Создать текстовый файл f с 10 целыми числами. Вывести количество чисел, больших 100.
    public static void task5() {
        System.out.println("\n=== ЗАДАНИЕ 5: Количество чисел из 10, больших 100 ===");
        File fileF = new File("f_task5.txt");
        int[] sampleNumbers = {45, 120, 99, 101, 250, -15, 100, 340, 88, 512};

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileF, StandardCharsets.UTF_8))) {
            for (int num : sampleNumbers) {
                writer.println(num);
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания файла f: " + e.getMessage());
            return;
        }

        int countGreater100 = 0;
        System.out.print("Числа в файле f: ");
        try (Scanner fileScanner = new Scanner(fileF, StandardCharsets.UTF_8)) {
            while (fileScanner.hasNextInt()) {
                int num = fileScanner.nextInt();
                System.out.print(num + " ");
                if (num > 100) {
                    countGreater100++;
                }
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла f: " + e.getMessage());
            return;
        }

        System.out.println("Количество чисел, больших 100: " + countGreater100);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Лабораторная работа № 14 (Вариант 16)");
        System.out.println("Выберите номер задания (1-5) или 0 для выполнения всех по очереди:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> task1();
            case 2 -> task2(scanner);
            case 3 -> task3();
            case 4 -> task4(scanner);
            case 5 -> task5();
            case 0 -> {
                task1();
                task2(scanner);
                task3();
                task4(scanner);
                task5();
            }
            default -> System.out.println("Неверный номер задания.");
        }
    }
}
