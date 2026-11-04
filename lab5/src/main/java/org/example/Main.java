package org.example;

public class Main {
    public static void main(String[] args) {
        RoundTable table = new RoundTable(776.5, "Дерево");
        System.out.println("Площадь стола: " + table.area() + " кв.м");

        Planet[] planets = new Planet[6];
        planets[0] = new Planet("Меркурий", 4879, 57.9);
        planets[1] = new Planet("Венера", 12104, 108.2);
        planets[2] = new Planet("Земля", 12742, 149.6);
        planets[3] = new Planet("Марс", 6779, 227.9);
        planets[4] = new Planet("Юпитер", 139820, 778.6);
        planets[5] = new Planet("Сатурн", 116460, 1433.5);

        Planet maxDiameterPlanet = planets[0];
        Planet maxDistancePlanet = planets[0];

        for (Planet p : planets) {
            if (p.getDiameter() > maxDiameterPlanet.getDiameter()) {
                maxDiameterPlanet = p;
            }
            if (p.getDistanceFromSun() > maxDistancePlanet.getDistanceFromSun()) {
                maxDistancePlanet = p;
            }
        }

        System.out.println("Планета с максимальным диаметром: " + maxDiameterPlanet.getName());
        System.out.println("Планета с максимальным расстоянием от Солнца: " + maxDistancePlanet.getName());
    }
}
