package org.example;

public class Main {
    public static void main(String[] args) {
        Furniture baseFurniture = new Furniture("Комод", "МДФ", 12000);
        Table table = new Table("Письменный стол", "Дуб", 25000, 4);
        Chair chair = new Chair("Офисное кресло", "Экокожа", 15000, true);

        System.out.println("=== 1. Демонстрация перегрузки методов (статический полиморфизм) ===");
        System.out.println("Объект: " + table.getName());
        table.use();
        table.use("работы за ноутбуком");
        table.use(6);
        table.use("совещания", 4);

        System.out.println("\nОбъект: " + chair.getName());
        chair.use();
        chair.use("отдыха");
        chair.use(3);
        chair.use(8, true);

        System.out.println("\n=== 2. Демонстрация переопределения методов (динамический полиморфизм) ===");
        Furniture[] catalog = new Furniture[]{baseFurniture, table, chair};
        for (Furniture item : catalog) {
            System.out.println(item);
            System.out.println("Вызов getPurpose() полиморфно: " + item.getPurpose());
            if (item instanceof Table t) {
                System.out.println("  -> Это стол, количество ножек: " + t.getLegs());
            } else if (item instanceof Chair c) {
                System.out.println("  -> Это стул, наличие спинки: " + (c.isHasBackrest() ? "есть" : "нет"));
            }
            System.out.println();
        }
    }
}
