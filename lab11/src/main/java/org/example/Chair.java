package org.example;

public class Chair extends Furniture {
    private boolean hasBackrest;

    public Chair(String name, String material, double price, boolean hasBackrest) {
        super(name, material, price);
        this.hasBackrest = hasBackrest;
    }

    public boolean isHasBackrest() {
        return hasBackrest;
    }

    @Override
    public String getPurpose() {
        return "Для сидения";
    }

    // Дополнительный перегруженный метод в дочернем классе
    public void use(int hours, boolean adjustHeight) {
        System.out.println("Использую стул \"" + getName() + "\" " + hours + " часов (регулировка высоты: " + (adjustHeight ? "да" : "нет") + ")");
    }
}
