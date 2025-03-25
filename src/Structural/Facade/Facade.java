package Structural.Facade;

import java.util.Random;

class KiemTraTonKho {
    private Random random = new Random();

    public boolean kiemTraSanPham(String sanPham) {
        boolean coSanPham = random.nextBoolean();
        System.out.println("Kiểm tra tồn kho cho: " + sanPham + " - Kết quả: " + (coSanPham ? "Còn hàng" : "Hết hàng"));
        return coSanPham;
    }
}

class XuLyThanhToan {
    public boolean thanhToan(String khachHang, double soTien) {
        System.out.println("Xử lý thanh toán cho " + khachHang + " số tiền: " + soTien + " VND - Kết quả: Thành công");
        return true;
    }
}

class VanChuyen {
    public void sapXepVanChuyen(String sanPham, String diaChi) {
        System.out.println("Sắp xếp vận chuyển " + sanPham + " đến: " + diaChi);
    }
}

class DonHangFacade {
    private KiemTraTonKho tonKho;
    private XuLyThanhToan thanhToan;
    private VanChuyen vanChuyen;

    public DonHangFacade() {
        this.tonKho = new KiemTraTonKho();
        this.thanhToan = new XuLyThanhToan();
        this.vanChuyen = new VanChuyen();
    }

    public void datHang(String sanPham, String khachHang, double soTien, String diaChi) {
        System.out.println("Bắt đầu xử lý đơn hàng...");

        if (!tonKho.kiemTraSanPham(sanPham)) {
            System.out.println("Sản phẩm không đủ số lượng tồn kho. Đơn hàng bị hủy.");
            return;
        }

        thanhToan.thanhToan(khachHang, soTien);
        vanChuyen.sapXepVanChuyen(sanPham, diaChi);
        System.out.println("Đơn hàng hoàn tất!");
    }
}



public class Facade {
    public static void main(String[] args) {
        DonHangFacade donHangFacade = new DonHangFacade();
        donHangFacade.datHang("Laptop", "Trương Tuấn Huy", 150, "Sài Gòn");
    }
}
