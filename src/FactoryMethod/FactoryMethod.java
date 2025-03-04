package FactoryMethod;

interface Food {
    void prepare();
    void cook();
    void serve();
}

class Pizza implements Food {
    public void prepare() {
        System.out.println("chuẩn bị Pizza");
    }
    public void cook() {
        System.out.println("nấu Pizza");
    }
    public void serve() {
        System.out.println("phục vụ Pizza");
    }
}

class Burger implements Food {
    public void prepare() {
        System.out.println("chuẩn bị Burger");
    }
    public void cook() {
        System.out.println("nấu Burger");
    }
    public void serve() {
        System.out.println("phục vụ Burger");
    }
}

class Pasta implements Food {
    public void prepare() {
        System.out.println("chuẩn bị Pasta");
    }
    public void cook() {
        System.out.println("nấu Pasta");
    }
    public void serve() {
        System.out.println("phục vụ Pasta");
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        Food pasta = new Pasta();
        pasta.prepare();
        pasta.cook();
        pasta.serve();
    }
}
