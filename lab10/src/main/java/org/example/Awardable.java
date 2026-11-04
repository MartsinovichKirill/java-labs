package org.example;

import java.util.List;

public interface Awardable {
    List<String> getAwards();
    void addAward(String award);

    default void printAwardsSummary() {
        System.out.println("Количество наград: " + getAwards().size());
    }
}
