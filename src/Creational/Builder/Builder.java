package Creational.Builder;

class Diet {
    private String protein;
    private String carbohydrate;
    private String vegetables;
    private String drink;

    Diet(DietBuilder builder) {
        this.protein = builder.protein;
        this.carbohydrate = builder.carbohydrate;
        this.vegetables = builder.vegetables;
        this.drink = builder.drink;
    }

    public void displayInfo() {
        System.out.println("Chế độ ăn gồm:");
        System.out.println("- Protein: " + protein);
        System.out.println("- Carbohydrate: " + carbohydrate);
        System.out.println("- Rau củ quả: " + vegetables);
        if (drink != null) {
            System.out.println("- Đồ uống: " + drink);
        }
    }
}

class DietBuilder {
    String protein;
    String carbohydrate;
    String vegetables;
    String drink;

    public DietBuilder setProtein(String protein) {
        this.protein = protein;
        return this;
    }

    public DietBuilder setCarbohydrate(String carbohydrate) {
        this.carbohydrate = carbohydrate;
        return this;
    }

    public DietBuilder setVegetables(String vegetables) {
        this.vegetables = vegetables;
        return this;
    }

    public DietBuilder setDrink(String drink) {
        this.drink = drink;
        return this;
    }

    public Diet build() {
        if (protein == null || carbohydrate == null || vegetables == null) {
            throw new IllegalStateException("Chế độ ăn phải có ít nhất một nguồn Protein, một nguồn Carbohydrate, và ít nhất một loại Rau củ quả.");
        }
        return new Diet(this);
    }
}

class DietDirector {
    public Diet createMediterraneanDiet() {
        return new DietBuilder()
                .setProtein("Thịt cá")
                .setCarbohydrate("Dầu ô liu")
                .setVegetables("Rau quả tươi")
                .setDrink("Rượu vang đỏ")
                .build();
    }

    public Diet createDashDiet() {
        return new DietBuilder()
                .setProtein("Thịt gà")
                .setCarbohydrate("Gạo lứt")
                .setVegetables("Rau xanh")
                .setDrink("Nước ép trái cây")
                .build();
    }

    public Diet createVegetarianDiet() {
        return new DietBuilder()
                .setProtein("Đậu hũ")
                .setCarbohydrate("Khoai tây")
                .setVegetables("Rau củ hỗn hợp")
                .setDrink("Nước lọc")
                .build();
    }
}

public class Builder {
    public static void main(String[] args) {
        DietDirector director = new DietDirector();

        Diet mediterraneanDiet = director.createMediterraneanDiet();
        Diet dashDiet = director.createDashDiet();
        Diet vegetarianDiet = director.createVegetarianDiet();

        mediterraneanDiet.displayInfo();
        dashDiet.displayInfo();
        vegetarianDiet.displayInfo();
    }
}
