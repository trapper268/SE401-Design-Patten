package Creational.Singleton;

import java.util.ArrayList;
import java.util.List;

class Patient {
    private int id;
    private String name;
    private int age;
    private String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void showInfo() {
        System.out.println("ID: " + id + " | Tên: " + name + " | Tuổi: " + age + " | Bệnh: " + disease);
    }
}

class PatientRecordManager {
    private static PatientRecordManager instance;
    private List<Patient> patientRecords;

    private PatientRecordManager() {
        patientRecords = new ArrayList<Patient>();
    }

    public static synchronized PatientRecordManager getInstance() {
        if (instance == null) {
            instance = new PatientRecordManager();
        }
        return instance;
    }

    public void addPatient(Patient patient) {
        patientRecords.add(patient);
        System.out.println("Thêm mới bệnh nhân: " + patient.getId());
    }

    public Patient findById(int id) {
        for (Patient p : patientRecords) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void updatePatient(int id, String name, int age, String disease) {
        Patient patient = findById(id);
        if (patient != null) {
            patient.setName(name);
            patient.setAge(age);
            patient.setDisease(disease);
            System.out.println("Cập nhật bệnh nhân có id: " + id);
        } else {
            System.out.println("Không tìm thấy bệnh nhân có id: " + id);
        }
    }

    public void getAllPatients() {
        if (patientRecords.isEmpty()) {
            System.out.println("Chưa có bệnh nhân nào");
        } else {
            System.out.println("Danh sách bệnh nhân:");
            for (Patient p : patientRecords) {
                p.showInfo();
            }
        }
    }
}

public class Singleton {
    public static void main(String[] args) {
        PatientRecordManager manager = PatientRecordManager.getInstance();

        manager.addPatient(new Patient(1, "Peso", 23, "Cúm"));
        manager.addPatient(new Patient(2, "Khoa pug", 19, "COVID-19"));
        manager.addPatient(new Patient(3, "GS Lộc", 21, "Ung thư não"));

        manager.getAllPatients();

        manager.updatePatient(2, "Lộc Pino", 20, "Đã hết COVID");

        manager.getAllPatients();

        Patient patient = manager.findById(1);
        if (patient != null) {
            System.out.println("Thông tin bệnh nhân có ID " + patient.getId());
            patient.showInfo();
        } else {
            System.out.println("Không tìm thấy bệnh nhân");
        }
    }
}
