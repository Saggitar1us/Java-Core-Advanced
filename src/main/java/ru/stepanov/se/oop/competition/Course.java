package ru.stepanov.se.oop.competition;

import ru.stepanov.se.oop.members.Team;

import java.util.Random;

public class Course {
    private CourseLine[] courseLine;
    private final Random random = new Random();

    public Course(CourseLine[] courseLine) {
        this.courseLine = courseLine;
    }

    /*
    Используется класс Random, для случайного выбора игрока, который прошел препятствие
    */
    public void doIt(Team team) {
        String[] members = team.getMembers();
        if (members != null) {
            for (CourseLine line : courseLine) {
                for (String member : members) {
                    if (random.nextBoolean()) { // if true that write to list of result
                        team.setResult(line, member);
                    }
                }
            }
        } else {
            System.out.println("Error: don't course, because the list of members is empty");
        }
    }
}

