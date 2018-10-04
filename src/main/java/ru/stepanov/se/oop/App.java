package ru.stepanov.se.oop;

import ru.stepanov.se.oop.competition.Course;
import ru.stepanov.se.oop.competition.CourseLine;
import ru.stepanov.se.oop.members.Team;

public class App {
    public static void main(String[] args) {
        Team team = new Team(
                new String[]
                        {"John", "Rico", "Paul", "Alisa"}
        );

        Course course = new Course(
                new CourseLine[]{
                        CourseLine.HURDLE_RACE,
                        CourseLine.RUN,
                        CourseLine.SWIM,
                        CourseLine.TIGHTENING_UP
                });

        course.doIt(team);
        team.showAllTeam();
        team.showResults();
    }
}
