package utils;

import java.util.Objects;

import static java.lang.Math.abs;

public class Asteroids {
    public int x;
    public int y;

    public Asteroids(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int manhattanDistanceTo(Asteroids other) {
        return abs(x - other.x) + abs(y - other.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asteroids Asteroids = (Asteroids) o;
        return x == Asteroids.x &&
               y == Asteroids.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}