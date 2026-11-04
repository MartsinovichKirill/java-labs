package org.example;

import java.util.ArrayList;
import java.util.List;

public class Singer implements Performer, Awardable {
    private String name;
    private String genre;
    private List<String> awards;

    public Singer(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.awards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public void perform() {
        System.out.println("Певец " + name + " исполняет композицию в жанре " + genre + ".");
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public List<String> getAwards() {
        return awards;
    }

    @Override
    public void addAward(String award) {
        awards.add(award);
        System.out.println("Исполнителю " + name + " вручена награда: \"" + award + "\"");
    }

    @Override
    public String toString() {
        return "Singer {name='" + name + "', genre='" + genre + "', awards=" + awards + "}";
    }
}
