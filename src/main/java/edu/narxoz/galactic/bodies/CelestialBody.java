package edu.narxoz.galactic.bodies;

public abstract class CelestialBody {
    private String name;
    private double x, y;

    protected CelestialBody(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() { return name; }
    public double getX() { return x; }
    public double getY() { return y; }

    public double distanceTo(CelestialBody other) {
        if (other == null) throw new IllegalArgumentException("Other body cannot be null");
        return Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2));
    }
}