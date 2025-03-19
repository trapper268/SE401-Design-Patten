package Adapter;

interface Course {
    void start();
    String getDetails();
}

class InpersonCourse implements Course {

    public void start() {
        attendClass();
    }

    public String getDetails() {
        return getSchedule();
    }

    public void attendClass() {
        System.out.println("Attending in-person class.");
    }

    public String getSchedule() {
        return "Schedule for in-person course.";
    }
}

class OnlineCourse {
    public void joinSession() {
        System.out.println("Joining online session.");
    }

    public String viewTimetable() {
        return "Timetable for online course.";
    }
}

class OnlineCourseAdapter implements Course {
    private OnlineCourse onlineCourse;

    public OnlineCourseAdapter(OnlineCourse onlineCourse) {
        this.onlineCourse = onlineCourse;
    }

    public void start() {
        onlineCourse.joinSession();
    }

    public String getDetails() {
        return onlineCourse.viewTimetable();
    }
}

class SelfStudyCourse {
    public void accessMaterial() {
        System.out.println("Accessing self-study materials.");
    }

    public String getDeadline() {
        return "Deadline for self-study course.";
    }
}

class SelfStudyCourseAdapter implements Course {
    private SelfStudyCourse selfStudyCourse;

    public SelfStudyCourseAdapter(SelfStudyCourse selfStudyCourse) {
        this.selfStudyCourse = selfStudyCourse;
    }

    public void start() {
        selfStudyCourse.accessMaterial();
    }

    public String getDetails() {
        return selfStudyCourse.getDeadline();
    }
}

public class Adapter {
    public static void main(String[] args) {
        Course inPerSonCourse = new InpersonCourse();
        OnlineCourse onlineCourse = new OnlineCourse();
        SelfStudyCourse selfStudyCourse = new SelfStudyCourse();

        OnlineCourseAdapter onlineCourseAdapter = new OnlineCourseAdapter(onlineCourse);
        SelfStudyCourseAdapter selfStudyCourseAdapter = new SelfStudyCourseAdapter(selfStudyCourse);

        inPerSonCourse.start();
        System.out.println(inPerSonCourse.getDetails());

        onlineCourseAdapter.start();
        System.out.println(onlineCourseAdapter.getDetails());

        selfStudyCourseAdapter.start();
        System.out.println(selfStudyCourseAdapter.getDetails());
    }
}
