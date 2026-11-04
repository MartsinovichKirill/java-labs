package org.example;

public interface Performer {
    void perform();
    String getGenre();

    static void announce(String name, String role) {
        System.out.println(">>> На сцену приглашается " + role + ": " + name + "!");
    }
}
