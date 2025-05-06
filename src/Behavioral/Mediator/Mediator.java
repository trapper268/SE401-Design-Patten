package Behavioral.Mediator;

import java.util.ArrayList;
import java.util.List;

enum LightColor {
    GREEN, YELLOW, RED
}

interface TrafficMediator {
    void registerLight(TrafficLight light);
    void changeLight(TrafficLight light);
}

class TrafficLight {
    private String direction;
    private LightColor color;
    private TrafficMediator mediator;

    public TrafficLight(String direction, TrafficMediator mediator) {
        this.direction = direction;
        this.mediator = mediator;
        this.color = LightColor.RED;
        mediator.registerLight(this);
    }

    public void turnGreen() {
        color = LightColor.GREEN;
        System.out.println("Đèn " + direction + " chuyển sang XANH");
        mediator.changeLight(this);
    }

    public void turnRed() {
        color = LightColor.RED;
        System.out.println("Đèn " + direction + " chuyển sang ĐỎ");
    }

    public void turnYellow() {
        color = LightColor.YELLOW;
        System.out.println("Đèn " + direction + " chuyển sang VÀNG");
    }

    public String getDirection() {
        return direction;
    }

    public LightColor getColor() {
        return color;
    }
}

class IntersectionMediator implements TrafficMediator {
    private List<TrafficLight> lights = new ArrayList<>();

    @Override
    public void registerLight(TrafficLight light) {
        lights.add(light);
    }

    @Override
    public void changeLight(TrafficLight activeLight) {
        for (TrafficLight light : lights) {
            if (!light.equals(activeLight)) {
                light.turnRed();
            }
        }
    }
}

public class Mediator {
    public static void main(String[] args) {
        TrafficMediator mediator = new IntersectionMediator();

        TrafficLight north = new TrafficLight("Bắc", mediator);
        TrafficLight south = new TrafficLight("Nam", mediator);
        TrafficLight east = new TrafficLight("Đông", mediator);
        TrafficLight west = new TrafficLight("Tây", mediator);

        north.turnGreen();
        north.turnYellow();

        System.out.println("---");
        east.turnGreen();
    }
}
