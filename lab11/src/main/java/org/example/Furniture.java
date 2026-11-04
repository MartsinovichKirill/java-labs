package org.example;

public class Furniture {
    private String name;
    private String material;
    private double price;

    public Furniture(String name, String material, double price) {
        this.name = name;
        this.material = material;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    // Перегруженные методы (статический полиморфизм)
    public void use() {
        System.out.println("Использую мебель");
    }

    public void use(String purpose) {
        System.out.println("Использую для " + purpose);
    }

    public void use(int hours) {
        System.out.println("Использую " + hours + " часов");
    }

    // Метод для переопределения (динамический полиморфизм)
    public String getPurpose() {
        return "Неизвестно";
    }

    @Override
    public String toString() {
        return name + " (материал: " + material + ", цена: " + price + " руб., назначение: " + getPurpose() + ")";
    }
}
