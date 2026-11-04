package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void printClubs(List<Club> clubs, int division) {
        System.out.println("Клубы в дивизионе " + division + ":");
        boolean found = false;
        for (Club club : clubs) {
            if (club.getDivision() == division) {
                System.out.println("  - " + club);
                found = true;
            }
        }
        if (!found) {
            System.out.println("  (нет клубов в данном дивизионе)");
        }
    }

    public static void main(String[] args) {
        System.out.println("================ ЗАДАНИЕ 1 (Вариант 16: Профессии) ================");
        Map<String, Professional> professionals = new LinkedHashMap<>();

        // 3 Doctor
        professionals.put("Иванов И.И.", new Doctor("Иванов И.И.", 101, 12, "Кардиолог"));
        professionals.put("Петрова А.С.", new Doctor("Петрова А.С.", 102, 8, "Невролог"));
        professionals.put("Сидоров В.П.", new Doctor("Сидоров В.П.", 103, 15, "Хирург"));

        // 3 Lawyer
        professionals.put("Смирнов Д.А.", new Lawyer("Смирнов Д.А.", 201, 10, 85));
        professionals.put("Козлова Е.В.", new Lawyer("Козлова Е.В.", 202, 6, 42));
        professionals.put("Морозов Н.К.", new Lawyer("Морозов Н.К.", 203, 20, 150));

        // 2 Teacher
        professionals.put("Васильева О.М.", new Teacher("Васильева О.М.", 301, 14, 90));
        professionals.put("Новиков С.Г.", new Teacher("Новиков С.Г.", 302, 5, 60));

        System.out.println("Все ключи Map:");
        for (String key : professionals.keySet()) {
            System.out.println("  Ключ: " + key);
        }

        System.out.println("\nВсе значения Map (ключ -> значение):");
        for (Map.Entry<String, Professional> entry : professionals.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\n================ ЗАДАНИЕ 2 (Вариант 16: Клубы) ================");
        List<Club> clubs = new ArrayList<>();
        clubs.add(new Club(1, "Динамо", "Футбол", 1, List.of(5, 4, 5, 4)));       // avg = 4.50
        clubs.add(new Club(2, "Спартак", "Футбол", 1, List.of(4, 5, 4, 5)));      // avg = 4.50
        clubs.add(new Club(3, "Металлург", "Хоккей", 2, List.of(2, 3, 2, 2)));    // avg = 2.25 (< 3, удалится)
        clubs.add(new Club(4, "Зенит", "Баскетбол", 2, List.of(3, 4, 3, 4)));     // avg = 3.50
        clubs.add(new Club(5, "Авангард", "Хоккей", 1, List.of(5, 5, 4, 5)));     // avg = 4.75
        clubs.add(new Club(6, "Волна", "Волейбол", 3, List.of(1, 2, 2, 1)));      // avg = 1.50 (< 3, удалится)

        System.out.println("Исходный список клубов:");
        clubs.forEach(c -> System.out.println("  " + c));

        // 1. Удалить клубы со средним рейтингом < 3 и 2. Повысить дивизион клубов со средним рейтингом >= 4
        Iterator<Club> iterator = clubs.iterator();
        while (iterator.hasNext()) {
            Club club = iterator.next();
            double avg = club.getAverageRating();
            if (avg < 3.0) {
                iterator.remove();
            } else if (avg >= 4.0) {
                club.setDivision(club.getDivision() + 1);
            }
        }

        System.out.println("\nПосле удаления клубов с рейтингом < 3 и повышения дивизиона (при рейтинге >= 4):");
        clubs.forEach(c -> System.out.println("  " + c));

        // 3. Печать клубов на заданном дивизионе
        System.out.println();
        printClubs(clubs, 2);

        // 4. Упорядочить все клубы по убыванию среднего рейтинга, при совпадении - по названию по алфавиту
        clubs.sort(Comparator.comparingDouble(Club::getAverageRating).reversed()
                .thenComparing(Club::getName));

        System.out.println("\nОтсортированный список клубов (ID, название, средний рейтинг):");
        for (Club club : clubs) {
            System.out.printf("  ID: %d | Название: %-12s | Средний рейтинг: %.2f%n",
                    club.getId(), club.getName(), club.getAverageRating());
        }
    }
}
