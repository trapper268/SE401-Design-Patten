package Behavioral.State;

class Lawsuit {
    private States currentState;

    public Lawsuit(States initialState) {
        this.currentState = initialState;
    }

    public void setState(States newState) {
        this.currentState = newState;
    }

    public void nextState() {
        currentState.handleNext(this);
    }

    public void displayState() {
        System.out.println("Trạng thái hiện tại của vụ án: " + currentState.getStateName());
    }
}

interface States {
    void handleNext(Lawsuit lawsuit);
    String getStateName();
}

class FilingState implements States {
    @Override
    public void handleNext(Lawsuit lawsuit) {
        System.out.println("Chuyển sang trạng thái Đang Xét Xử.");
        lawsuit.setState(new TrialState());
    }

    @Override
    public String getStateName() {
        return "Khởi Kiện";
    }
}

class TrialState implements States {
    @Override
    public void handleNext(Lawsuit lawsuit) {
        System.out.println("Chuyển sang trạng thái Chờ Phán Quyết.");
        lawsuit.setState(new AwaitingJudgmentState());
    }

    @Override
    public String getStateName() {
        return "Đang Xét Xử";
    }
}

class AwaitingJudgmentState implements States {
    @Override
    public void handleNext(Lawsuit lawsuit) {
        System.out.println("Chuyển sang trạng thái Đã Hoàn Tất.");
        lawsuit.setState(new ClosedState());
    }

    @Override
    public String getStateName() {
        return "Chờ Phán Quyết";
    }
}

class ClosedState implements States {
    @Override
    public void handleNext(Lawsuit lawsuit) {
        System.out.println("Vụ án đã hoàn tất. Không thể chuyển trạng thái tiếp theo.");
    }

    @Override
    public String getStateName() {
        return "Đã Hoàn Tất";
    }
}



public class State {
    public static void main(String[] args) {
        Lawsuit lawsuit = new Lawsuit(new FilingState());

        lawsuit.displayState();
        lawsuit.nextState();

        lawsuit.displayState();
        lawsuit.nextState();

        lawsuit.displayState();
        lawsuit.nextState();

        lawsuit.displayState();
        lawsuit.nextState();
    }
}
