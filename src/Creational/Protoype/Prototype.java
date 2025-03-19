package Creational.Protoype;

import java.util.ArrayList;
import java.util.List;

abstract class EntertainmentProgram {
    protected String name;
    protected int duration;
    protected String type;

    public EntertainmentProgram(String name, int duration, String type) {
        this.name = name;
        this.duration = duration;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public abstract EntertainmentProgram clone();

    public void displayInfo() {
        System.out.println("Loại hình giải trí: " + type + " | Tên: " + name + " | Thời lượng: " + duration);
    }
}

class Movie extends EntertainmentProgram {
    public Movie(String name, int duration) {
        super(name, duration, "Movie");
    }

    @Override
    public Movie clone() {
        return new Movie(this.name, this.duration);
    }
}

class TVShow extends EntertainmentProgram {
    public TVShow(String name, int duration) {
        super(name, duration, "TV Show");
    }

    @Override
    public TVShow clone() {
        return new TVShow(this.name, this.duration);
    }
}

class MusicEvent extends EntertainmentProgram {
    public MusicEvent(String name, int duration) {
        super(name, duration, "Music Event");
    }

    @Override
    public MusicEvent clone() {
        return new MusicEvent(this.name, this.duration);
    }
}

class EntertainmentManager {
    private List<EntertainmentProgram> items = new ArrayList<>();

    public void addItem(EntertainmentProgram i) {
        items.add(i);
    }

    public EntertainmentProgram cloneByName(String name) {
        for (EntertainmentProgram prototype : items) {
            if (prototype.getName().equals(name)) {
                return prototype.clone();
            }
        }
        return null;
    }
}


public class Prototype {
    public static void main(String[] args) {
        EntertainmentManager manager = new EntertainmentManager();
        manager.addItem(new Movie("Inception", 148));
        manager.addItem(new TVShow("Breaking Bad", 50));
        manager.addItem(new MusicEvent("Coachella", 180));

        EntertainmentProgram clonedMovie = manager.cloneByName("Inception");
        EntertainmentProgram clonedTVShow = manager.cloneByName("Breaking Bad");
        EntertainmentProgram clonedMusicEvent = manager.cloneByName("Coachella");
        EntertainmentProgram clonedNotExist = manager.cloneByName("Peso");

        if (clonedMovie != null) clonedMovie.displayInfo();
        if (clonedTVShow != null) clonedTVShow.displayInfo();
        if (clonedMusicEvent != null) clonedMusicEvent.displayInfo();
        if (clonedNotExist == null) {
            System.out.println("Không tìm thấy chương trình phù hợp!");
        }
    }
}
