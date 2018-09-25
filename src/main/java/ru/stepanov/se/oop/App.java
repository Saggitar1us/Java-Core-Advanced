package ru.stepanov.se.oop;

import ru.stepanov.se.oop.competition.Course;
import ru.stepanov.se.oop.competition.CourseLine;
import ru.stepanov.se.oop.members.Team;

/**
 *
 *
 *
 *
 * В итоге должно быть что-то вроде:
 *
 * public static void main(String[] args) {
 * Course c = new Course(...); // Создаем полосу препятствий
 * Team team = new Team(...); // Создаем команду
 * c.doIt(team); // Просим команду пройти полосу
 * team.showResults(); // Показываем результаты
 * }
 */
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
