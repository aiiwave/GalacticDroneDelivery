package edu.narxoz.galactic;

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.dispatcher.Result;
import edu.narxoz.galactic.drones.*;
import edu.narxoz.galactic.task.DeliveryTask;

public class Main {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();

        Planet earth = new Planet("Earth", 0, 0, "Oxygen");
        SpaceStation moonBase = new SpaceStation("Moon Base", 100, 200, 1);

        Cargo heavyBox = new Cargo(500, "Mining Equipment");
        LightDrone light = new LightDrone("L-1", 100);
        HeavyDrone heavy = new HeavyDrone("H-1", 1000);

        DeliveryTask task = new DeliveryTask(earth, moonBase, heavyBox);

        Result r1 = dispatcher.assignTask(task, light);
        System.out.println("LightDrone assignment: " + (r1.ok() ? "Success" : "Failed - " + r1.reason()));

        Result r2 = dispatcher.assignTask(task, heavy);
        System.out.println("HeavyDrone assignment: " + (r2.ok() ? "Success" : "Failed"));

        System.out.println("Estimated travel time: " + task.estimateTime() + " min");

        Result r3 = dispatcher.completeTask(task);
        System.out.println("Task completion: " + (r3.ok() ? "Success" : "Failed"));
        System.out.println("Final Task State: " + task.getState());
        System.out.println("Final Drone Status: " + heavy.getStatus());
    }
}