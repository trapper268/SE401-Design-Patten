package Structural.Decorator;

interface Linh {
    String getItem();
}

class LinhCoBan implements Linh {
    public String getItem() {
        return "Quân trang: Balo, Quần áo, Nón";
    }
}

abstract class LinhDecorator implements Linh {
    protected Linh linh;

    public LinhDecorator(Linh linh) {
        this.linh = linh;
    }

    public String getItem() {
        return linh.getItem();
    }
}

class VuKhi extends LinhDecorator {
    private String vuKhi;

    public VuKhi(Linh linh, String vuKhi) {
        super(linh);
        this.vuKhi = vuKhi;
    }

    public String getItem() {
        return super.getItem() + "; Vũ khí: " + vuKhi;
    }
}

class KyNang extends LinhDecorator {
    private String kyNang;

    public KyNang(Linh linh, String kyNang) {
        super(linh);
        this.kyNang = kyNang;
    }

    public String getItem() {
        return super.getItem() + "; Kỹ năng: " + kyNang;
    }
}

class QuanHam extends LinhDecorator {
    private String quanHam;

    public QuanHam(Linh linh, String quanHam) {
        super(linh);
        this.quanHam = quanHam;
    }

    public String getItem() {
        return super.getItem() + "; Quân hàm: " + quanHam;
    }
}

public class Decorator {
    public static void main(String[] args) {
        Linh linhCoBan = new LinhCoBan();

        Linh linh1 = new VuKhi(linhCoBan, "Súng");
        linh1 = new KyNang(linh1, "Bắn");
        linh1 = new QuanHam(linh1, "Thiếu úy");

        System.out.println("Người lính 1: " + linh1.getItem());

        Linh linh2 = new VuKhi(linhCoBan, "Áo giáp");
        linh2 = new KyNang(linh2, "Chữa trị");
        linh2 = new QuanHam(linh2, "Trung úy");

        System.out.println("Người lính 2: " + linh2.getItem());
    }
}
