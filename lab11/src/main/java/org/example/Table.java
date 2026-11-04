package org.example;

public class Table extends Furniture {
    private int legs;

    public Table(String name, String material, double price, int legs) {
        super(name, material, price);
        this.legs = legs;
    }

    public int getLegs() {
        return legs;
    }

    @Override
    public String getPurpose() {
        return "Для работы";
    }

    // Дополнительный перегруженный метод в дочернем классе
    public void use(String purpose, int peopleCount) {
        System.out.println("Использую стол \"" + getName() + "\" для " + purpose + " (человек за столом: " + peopleCount + ")");
    }
}
