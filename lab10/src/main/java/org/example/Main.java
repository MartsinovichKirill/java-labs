package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Создание 3 объектов Singer и 2 объектов Dancer (Вариант 16)
        Singer singer1 = new Singer("Фредди Меркьюри", "Рок");
        Singer singer2 = new Singer("Адель", "Соул / Поп");
        Singer singer3 = new Singer("Эминем", "Хип-хоп");

        Dancer dancer1 = new Dancer("Михаил Барышников", "Балет");
        Dancer dancer2 = new Dancer("Майкл Джексон", "Street dance / Moonwalk");

        System.out.println("1. ПРИСВОЕНИЕ НАГРАД");
        singer1.addAward("Grammy Hall of Fame");
        singer1.addAward("Brit Award");

        singer2.addAward("Grammy: Album of the Year");
        singer2.addAward("Oscar: Best Original Song");

        singer3.addAward("Grammy: Best Rap Album");

        dancer1.addAward("Prix Benois de la Danse");
        dancer1.addAward("Kennedy Center Honors");

        dancer2.addAward("MTV Video Vanguard Award");
        dancer2.addAward("American Dance Award");

        System.out.println("\n2. ДЕМОНСТРАЦИЯ ЧЕРЕЗ ИНТЕРФЕЙСНЫЙ ТИП Performer");
        List<Performer> troupe = new ArrayList<>();
        troupe.add(singer1);
        troupe.add(singer2);
        troupe.add(singer3);
        troupe.add(dancer1);
        troupe.add(dancer2);

        for (Performer artist : troupe) {
            artist.perform();
            System.out.println("Жанр/Стиль: " + artist.getGenre());
        }

        System.out.println("\n3. ДЕМОНСТРАЦИЯ ЧЕРЕЗ ИНТЕРФЕЙСНЫЙ ТИП Awardable");
        List<Awardable> awardables = new ArrayList<>();
        awardables.add(singer1);
        awardables.add(singer2);
        awardables.add(singer3);
        awardables.add(dancer1);
        awardables.add(dancer2);

        for (Awardable item : awardables) {
            System.out.println("Список наград: " + item.getAwards());
            item.printAwardsSummary();
            System.out.println();
        }
    }
}
