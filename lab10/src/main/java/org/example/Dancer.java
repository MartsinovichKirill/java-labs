package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dancer implements Performer, Awardable {
    private String name;
    private String style;
    private List<String> awards;

    public Dancer(String name, String style) {
        this.name = name;
        this.style = style;
        this.awards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public void perform() {
        System.out.println("Танцор " + name + " исполняет танец в стиле " + style + ".");
    }

    @Override
    public String getGenre() {
        return style;
    }

    @Override
    public List<String> getAwards() {
        return awards;
    }

    @Override
    public void addAward(String award) {
        awards.add(award);
        System.out.println("Танцору " + name + " вручена награда: \"" + award + "\"");
    }

    @Override
    public String toString() {
        return "Dancer {name='" + name + "', style='" + style + "', awards=" + awards + "}";
    }
}
