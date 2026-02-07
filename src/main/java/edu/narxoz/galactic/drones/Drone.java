package edu.narxoz.galactic.drones;

public abstract class Drone {
    private String id;
    private DroneStatus status = DroneStatus.IDLE;
    private double maxPayloadKg;

    protected Drone(String id, double maxPayloadKg) {
        if (maxPayloadKg <= 0) throw new IllegalArgumentException("Max payload must be > 0");
        this.id = id;
        this.maxPayloadKg = maxPayloadKg;
    }

    public abstract double speedKmPerMin();

    public String getId() {
        return id;}
    public DroneStatus getStatus() {
        return status;}
    public void setStatus(DroneStatus status) {
        this.status = status;}
    public double getMaxPayloadKg() {
        return maxPayloadKg;}
}