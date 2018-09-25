package ru.stepanov.se.oop.members;

import ru.stepanov.se.oop.competition.CourseLine;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Team {
    private String[] members;
    private HashMap<CourseLine, String> TeamResult = new HashMap<>();

    public Team(String[] members) {
        if (members.length == 4) {
            this.members = members;
        } else {
            System.out.println("Error: The count of members should be 4.\nActual length: " + members.length);
            return;
        }
    }

    public void showAllTeam() {
        if (members != null) {
            System.out.println("All members of team: ");
            Stream.of(members).forEach(System.out::println);
            System.out.println();
        } else {
            System.out.println("The list of members is empty");
        }
    }

    public String[] getMembers() {
        return members;
    }

    public void setResult(CourseLine line, String member) {
        TeamResult.put(line, member);
    }

    public void showResults() {
        System.out.println("The members who win of course line:");
        if (TeamResult != null) {
            for (Map.Entry<CourseLine, String> result : TeamResult.entrySet()) {
                System.out.println("Name: " + result.getValue() + "\ncourse: " + result.getKey() + "\n");
            }
        } else {
            System.out.println("The win list of result members is empty");
        }
    }
}
