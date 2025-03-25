package Structural.Composite;

import java.util.ArrayList;
import java.util.List;

interface MedicalService {
    String getDescription();
    double getCost();
}

class Consultation implements MedicalService {
    public String getDescription() {
        return "Khám bệnh";
    }

    public double getCost() {
        return 100;
    }
}

class XRay implements MedicalService {
    public String getDescription() {
        return "Chụp X-Ray";
    }

    public double getCost() {
        return 200;
    }
}

class Surgery implements MedicalService {
    public String getDescription() {
        return "Phẩu thuật";
    }

    public double getCost() {
        return 300;
    }
}

class CompositeMedicalService implements MedicalService {
    private String name;
    private List<MedicalService> medicalServices = new ArrayList<>();

    public CompositeMedicalService(String name) {
        this.name = name;
    }

    public void addService(MedicalService service) {
        medicalServices.add(service);
    }

    public void removeService(MedicalService service) {
        medicalServices.remove(service);
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder(name + "bao gồm: ");
        for (MedicalService service : medicalServices) {
            description.append("\n- ").append(service.getDescription());
        }
        return description.toString();
    }

    public double getCost() {
        double total = 0;
        for (MedicalService service : medicalServices) {
            total += service.getCost();
        }
        return total;
    }
}

public class Composite {
    public static void main(String[] args) {
        MedicalService consultation = new Consultation();
        MedicalService xRay = new XRay();
        MedicalService surgery = new Surgery();

        CompositeMedicalService healthPackage = new CompositeMedicalService("Gói khám tổng quát");
        healthPackage.addService(consultation);
        healthPackage.addService(xRay);

        CompositeMedicalService advancedPackage = new CompositeMedicalService("Gói phẩu thuật não");
        advancedPackage.addService(surgery);
        advancedPackage.addService(healthPackage);

        System.out.println(consultation.getDescription());
        System.out.println("Tổng cộng:" + consultation.getCost() + "\n");

        System.out.println(healthPackage.getDescription());
        System.out.println("Tổng cộng: " + healthPackage.getCost() + "\n");

        System.out.println(advancedPackage.getDescription());
        System.out.println("Tổng cộng: " + advancedPackage.getCost());
    }
}
