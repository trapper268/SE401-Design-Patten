package Structural.Proxy;

interface Image {
    void display();
}

class ClothingImage implements Image {
    private String fileName;

    public ClothingImage(String fileName) {
        this.fileName = fileName;
        loadImage();
    }

    private void loadImage() {
        System.out.println("Tải hình: " + fileName);
    }

    public void display() {
        System.out.println("Hiển thị hình: " + fileName);
    }
}

class ProxyClothingImage implements Image {
    private ClothingImage realImage;
    private String fileName;

    public ProxyClothingImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new ClothingImage(fileName);
        }
        realImage.display();
    }
}

class ClothingItem {
    private String name;
    private double price;
    private ProxyClothingImage image;

    public ClothingItem(String name, double price, String imageFile) {
        this.name = name;
        this.price = price;
        this.image = new ProxyClothingImage(imageFile);
    }

    public void displayInfo() {
        System.out.println("Sản phẩm: " + name + " | Giá: /vnđ" + price);
    }

    public void viewImage() {
        image.display();
    }
}

public class Proxy {
    public static void main(String[] args) {
        ClothingItem item1 = new ClothingItem("Ao thun", 150, "peso.jpg");
        ClothingItem item2 = new ClothingItem("Jeans", 135, "jeans.png");

        item1.displayInfo();
        item2.displayInfo();

        System.out.println("\nCoi hinh ao thun:");
        item1.viewImage();

        System.out.println("\nCoi hinh jeans:");
        item2.viewImage();
    }
}
