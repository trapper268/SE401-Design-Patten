package Structural.Flyweight;

import java.util.ArrayList;
import java.util.List;

class Team {
    private final String name;
    private final String logo;
    private final String jerseyColor;

    public Team(String name, String logo, String jerseyColor) {
        this.name = name;
        this.logo = logo;
        this.jerseyColor = jerseyColor;
    }

    public void displayTeamInfo() {
        System.out.println("Đội: " + name + ", Màu: " + jerseyColor + ", Logo: " + logo);
    }

    public String getName() {
        return name;
    }
}

class TeamFactory {
    private static final List<Team> teams = new ArrayList<>();

    public static Team getTeam(String name, String logo, String jerseyColor) {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        Team newTeam = new Team(name, logo, jerseyColor);
        teams.add(newTeam);
        return newTeam;
    }
}

class Player {
    private final String name;
    private final int number;
    private final String position;
    private final Team team;

    public Player(String name, int number, String position, Team team) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.team = team;
    }

    public void displayPlayerInfo() {
        System.out.println("Player: " + name + " (#" + number + ", Position: " + position + ")");
        team.displayTeamInfo();
    }
}

public class Flyweight {
    public static void main(String[] args) {
        Team teamA = TeamFactory.getTeam("Team A", "Logo_A.png", "Đỏ");
        Team teamB = TeamFactory.getTeam("Team B", "Logo_B.png", "Xanh");

        Player player1 = new Player("A", 10, "Tiền đạo", teamA);
        Player player2 = new Player("B", 7, "Hậu hệ", teamA);
        Player player3 = new Player("C", 3, "Thủ môn", teamB);

        player1.displayPlayerInfo();
        player2.displayPlayerInfo();
        player3.displayPlayerInfo();
    }
}
