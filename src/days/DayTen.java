package days;

import java.util.*;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;


import utils.Asteroids;

import static java.lang.Math.atan2;
import static java.lang.Math.toDegrees;


public class DayTen {
    public String solvePartOne(String input) {
        Set<Asteroids> Asteroidss = parseAsteroidsField(input);

        int maxInLineOfSight = Integer.MIN_VALUE;
        Asteroids bestAsteroids = null;

        for (Asteroids center : Asteroidss) {
            Multimap<Double, Asteroids> headingToAsteroidsMap = getHeadingToAsteroidsMap(Asteroidss, center);
            if (headingToAsteroidsMap.keySet().size() > maxInLineOfSight) {
                bestAsteroids = center;
                maxInLineOfSight = headingToAsteroidsMap.keySet().size();
            }
        }

        assert bestAsteroids != null;

        // System.out.println("Best Asteroids " + bestAsteroids.x + "," + bestAsteroids.y);

        return String.valueOf(maxInLineOfSight);
    }

    public String solvePartTwo(String input) {
        // Best location for monitoring station was found in part one
        Asteroids locationOfMonitoringStation = new Asteroids(13,17);
        Set<Asteroids> Asteroidss = parseAsteroidsField(input);
        Multimap<Double, Asteroids> headingToAsteroidsMap = getHeadingToAsteroidsMap(Asteroidss, locationOfMonitoringStation);

        List<Double> headingsSorted = new ArrayList<>(headingToAsteroidsMap.keySet());
        headingsSorted.sort(Double::compare);

        int headingIndex = headingsSorted.indexOf(0.0);
        int AsteroidssZapped = 0;
        while (!Asteroidss.isEmpty()) {
            Double heading = headingsSorted.get(headingIndex++ % headingsSorted.size());
            if (headingToAsteroidsMap.containsKey(heading)) {
                // Closest Asteroids is first in the list
                Asteroids target = headingToAsteroidsMap.get(heading).iterator().next();

                // Zap it
                headingToAsteroidsMap.remove(heading, target);
                AsteroidssZapped++;

                if (AsteroidssZapped == 200) {
                    return String.valueOf(target.x * 100 + target.y);
                }
            }
        }

        throw new IllegalStateException();
    }

    private Multimap<Double, Asteroids> getHeadingToAsteroidsMap(Set<Asteroids> Asteroidss, Asteroids center) {
        // Sort by distance from center to each Asteroids
        List<Asteroids> othersByDistance = new ArrayList<>(Asteroidss);
        othersByDistance.remove(center);
        othersByDistance.sort(Comparator.comparingInt(center::manhattanDistanceTo));

        Multimap<Double, Asteroids> headingToAsteroidsMap = ArrayListMultimap.create();
        for (Asteroids other : othersByDistance) {
            double heading = toDegrees(atan2(other.x - center.x, -(other.y - center.y)));
            headingToAsteroidsMap.put(heading, other);
        }

        return headingToAsteroidsMap;
    }

    private Set<Asteroids> parseAsteroidsField(String input) {
        Set<Asteroids> Asteroidss = new HashSet<>();

        try (Scanner scanner = new Scanner(input)) {
            int y = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int x = 0; x < line.length(); x++) {
                    if (line.charAt(x) == '#') {
                        Asteroidss.add(new Asteroids(x, y));
                    }
                }
                y++;
            }
        }

        return Asteroidss;
    }
}