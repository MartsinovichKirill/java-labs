package org.example;

import java.util.List;

public class Club {
    private int id;
    private String name;
    private String sport;
    private int division;
    private List<Integer> matchRatings;

    public Club(int id, String name, String sport, int division, List<Integer> matchRatings) {
        this.id = id;
        this.name = name;
        this.sport = sport;
        this.division = division;
        this.matchRatings = matchRatings;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSport() {
        return sport;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public List<Integer> getMatchRatings() {
        return matchRatings;
    }

    public double getAverageRating() {
        if (matchRatings == null || matchRatings.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int rating : matchRatings) {
            sum += rating;
        }
        return (double) sum / matchRatings.size();
    }

    @Override
    public String toString() {
        return String.format("Club{id=%d, name='%s', sport='%s', division=%d, avgRating=%.2f}",
                id, name, sport, division, getAverageRating());
    }
}
