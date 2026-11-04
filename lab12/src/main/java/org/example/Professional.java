package org.example;

public class Professional {
    private String name;
    private int id;
    private int experience;

    public Professional(String name, int id, int experience) {
        this.name = name;
        this.id = id;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Имя: " + name + ", Опыт: " + experience + " лет";
    }
}
