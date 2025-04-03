package Behavioral.CoR;

class Patient {
    private String patientId;
    private String name;
    private String symptoms;

    public Patient(String patientId, String name, String symptoms) {
        this.patientId = patientId;
        this.name = name;
        this.symptoms = symptoms;
    }

    public String getName() {
        return name;
    }

    public String getSymptoms() {
        return symptoms;
    }
}

class Request {
    private Patient patient;

    public Request(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }
}

interface Handler {
    void setNextHandler(Handler handler);
    void handleRequest(Request request);
}

class BaseHandler implements Handler {
    protected Handler nextHandler;

    public void handleRequest(Request request) {
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }

    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }
}

class ReceptionHandler extends BaseHandler implements Handler {
    public void setNextHandler(Handler handler) {
        super.setNextHandler(handler);
    }

    public void handleRequest(Request request) {
        System.out.println("Lễ tân: Kiểm tra thông tin bệnh nhân " + request.getPatient().getName());
        super.handleRequest(request);
    }
}

class DiagnosisHandler extends BaseHandler implements Handler {
    public void setNextHandler(Handler handler) {
        super.setNextHandler(handler);
    }

    public void handleRequest(Request request) {
        System.out.println("Chẩn đoán: Chẩn đoán bệnh nhân " + request.getPatient().getName());
        super.handleRequest(request);
    }
}

class TreatmentHandler extends BaseHandler implements Handler {
    public void setNextHandler(Handler handler) {
        super.setNextHandler(handler);
    }

    public void handleRequest(Request request) {
        System.out.println("Điều trị: Điều trị " + request.getPatient().getSymptoms() + " cho bệnh nhân " + request.getPatient().getName());
        super.handleRequest(request);
    }
}

class ConsultationHandler extends BaseHandler implements Handler    {
    public void setNextHandler(Handler handler) {
        super.setNextHandler(handler);
    }

    public void handleRequest(Request request) {
        System.out.println("Tư vấn: Cung cấp tư vấn cho " + request.getPatient().getName());
    }
}

public class CoR {
    public static void main(String[] args) {
        Handler reception = new ReceptionHandler();
        Handler diagnosis = new DiagnosisHandler();
        Handler treatment = new TreatmentHandler();
        Handler consultation = new ConsultationHandler();

        reception.setNextHandler(diagnosis);
        diagnosis.setNextHandler(treatment);
        treatment.setNextHandler(consultation);

        Patient patient = new Patient("P001", "Peso", "Ung thư não");
        Request request = new Request(patient);

        reception.handleRequest(request);
    }
}
