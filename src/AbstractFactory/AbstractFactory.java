package AbstractFactory;

abstract class Car {
    protected String Engine;
    protected int Seat;
    protected float Size;

    public void Xuat() {
        System.out.println("Engine: " + Engine + ", Seat: " + Seat + ", Size: " + Size);
    }
}

class SedanCar extends Car {
    public SedanCar() {
        Engine = "Sedan Engine";
        Seat = 4;
        Size = 5;
    }
}
class SUVCar extends Car {
    public SUVCar() {
        Engine = "SUV Engine";
        Seat = 6;
        Size = 8;
    }
}
class ElectricCar extends Car {
    public ElectricCar() {
        Engine = "Electric Car";
        Seat = 7;
        Size = 9;
    }
}

class EuroSedanCar extends SedanCar {
    public EuroSedanCar() {
        super();
        Engine = "Euro " + Engine;
    }
}
class EuroSUVCar extends SUVCar {
    public EuroSUVCar() {
        Engine = "Euro " + Engine;
    }
}
class EuroElectricCar extends ElectricCar {
    public EuroElectricCar() {
        Engine = "Euro " + Engine;
    }
}

class AsianSedanCar extends SedanCar {
    public AsianSedanCar() {
        super();
        Engine = "Asian " + Engine;
    }
}
class AsianSUVCar extends SUVCar {
    public AsianSUVCar() {
        super();
        Engine = "Asian " + Engine;
    }
}
class AsianElectricCar extends ElectricCar {
    public AsianElectricCar() {
        super();
        Engine = "Asian " + Engine;
    }
}

interface CarFactory {
    Car createSedanCar();
    Car createSUVCar();
    Car createElectricCar();
}

class EuroCarFactory implements CarFactory {
    public Car createSedanCar() {
        return new EuroSedanCar();
    }
    public Car createSUVCar() {
        return new EuroSUVCar();
    }
    public Car createElectricCar() {
        return new EuroElectricCar();
    }
}

class AsianCarFactory implements CarFactory {
    public Car createSedanCar() {
        return new AsianSedanCar();
    }
    public Car createSUVCar() {
        return new AsianSUVCar();
    }
    public Car createElectricCar() {
        return new AsianElectricCar();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        CarFactory euro = new EuroCarFactory();
        Car euroSedanCar = euro.createSedanCar();
        euroSedanCar.Xuat();
    }
}