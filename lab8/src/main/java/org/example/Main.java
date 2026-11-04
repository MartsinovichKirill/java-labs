package org.example;

public class Main {
    public static void main(String[] args) {
        Artist[] artists = new Artist[]{
                new Singer("Фредди", 45, "Рок", "Тенор"),
                new Singer("Адель", 34, "Поп", "Меццо-сопрано"),
                new Singer("Лучано", 71, "Опера", "Тенор"),
                new Dancer("Михаил", 28, "Балет", "Классический"),
                new Dancer("Анна", 22, "Современный", "Хип-хоп")
        };

        for (int i = 0; i < artists.length; i++) {
            System.out.println("Артист " + (i + 1));
            artists[i].displayInfo();
            artists[i].perform();

            if (artists[i] instanceof Singer) {
                Singer s = (Singer) artists[i];
                s.singSong();
            } else if (artists[i] instanceof Dancer) {
                Dancer d = (Dancer) artists[i];
                d.choreograph();
            }
            System.out.println();
        }
    }
}
