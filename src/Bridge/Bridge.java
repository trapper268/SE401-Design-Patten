package Bridge;

interface IrrigationSystem {
    void waterPlants();
}

class DripIrrigation implements IrrigationSystem {
    public void waterPlants() {
        System.out.println("Watering plants using drip irrigation.");
    }
}

class SprinklerIrrigation implements IrrigationSystem {
    public void waterPlants() {
        System.out.println("Watering plants using sprinkler irrigation.");
    }
}

class ManualIrrigation implements IrrigationSystem {
    public void waterPlants() {
        System.out.println("Watering plants manually.");
    }
}

interface ControlSystem {
    void control();
}

abstract class BaseControlSystem implements ControlSystem {
    protected IrrigationSystem irrigationSystem;

    public BaseControlSystem(IrrigationSystem irrigationSystem) {
        this.irrigationSystem = irrigationSystem;
    }
}

class ManualControl extends BaseControlSystem {
    public ManualControl(IrrigationSystem irrigationSystem) {
        super(irrigationSystem);
    }

    public void control() {
        System.out.print("Manually controlling the irrigation system and ");
        this.irrigationSystem.waterPlants();
    }
}

class AutomaticControl extends BaseControlSystem {
    public AutomaticControl(IrrigationSystem irrigationSystem) {
        super(irrigationSystem);
    }

    public void control() {
        System.out.print("Automatically controlling the irrigation system and ");
        this.irrigationSystem.waterPlants();
    }
}

public class Bridge {
    public static void main(String[] args) {
        ControlSystem manualDrip = new ManualControl(new DripIrrigation());
        ControlSystem autoSprinkler = new AutomaticControl(new SprinklerIrrigation());
        ControlSystem manualHand = new ManualControl(new ManualIrrigation());

        manualDrip.control();

        autoSprinkler.control();

        manualHand.control();
    }
}
