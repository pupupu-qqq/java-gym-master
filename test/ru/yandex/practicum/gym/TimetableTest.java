//package ru.yandex.practicum.gym;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.*;
//
//public class TimetableTest {
////
//    @Test
//    void testGetTrainingSessionsForDaySingleSession() {
//        Timetable timetable = new Timetable();
//
//        Group group = new Group("Акробатика для детей", Age.CHILD, 60);
//        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");
//
//        TrainingSession singleTrainingSession = new TrainingSession(
//                group,
//                coach,
//                DayOfWeek.MONDAY,
//                new TimeOfDay(13, 0)
//        );
//
//        timetable.addNewTrainingSession(singleTrainingSession);
//
//        List<TrainingSession> mondaySessions =
//                timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY);
//
//        Assertions.assertEquals(1, mondaySessions.size());
//
//        List<TrainingSession> tuesdaySessions =
//                timetable.getTrainingSessionsForDay(DayOfWeek.TUESDAY);
//
//        Assertions.assertEquals(0, tuesdaySessions.size());
//    }
//
//    @Test
//    void testGetTrainingSessionsForDayMultipleSessions() {
//        Timetable timetable = new Timetable();
//
//        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");
//
//        Group groupAdult = new Group("Акробатика для взрослых", Age.ADULT, 90);
//        TrainingSession thursdayAdultTrainingSession = new TrainingSession(
//                groupAdult,
//                coach,
//                DayOfWeek.THURSDAY,
//                new TimeOfDay(20, 0)
//        );
//
//        timetable.addNewTrainingSession(thursdayAdultTrainingSession);
//
//        Group groupChild = new Group("Акробатика для детей", Age.CHILD, 60);
//
//        TrainingSession mondayChildTrainingSession = new TrainingSession(
//                groupChild,
//                coach,
//                DayOfWeek.MONDAY,
//                new TimeOfDay(13, 0)
//        );
//
//        TrainingSession thursdayChildTrainingSession = new TrainingSession(
//                groupChild,
//                coach,
//                DayOfWeek.THURSDAY,
//                new TimeOfDay(13, 0)
//        );
//
//        TrainingSession saturdayChildTrainingSession = new TrainingSession(
//                groupChild,
//                coach,
//                DayOfWeek.SATURDAY,
//                new TimeOfDay(10, 0)
//        );
//
//        timetable.addNewTrainingSession(mondayChildTrainingSession);
//        timetable.addNewTrainingSession(thursdayChildTrainingSession);
//        timetable.addNewTrainingSession(saturdayChildTrainingSession);
//
//        Assertions.assertEquals(
//                1,
//                timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY).size()
//        );
//
//        List<TrainingSession> thursdaySessions =
//                timetable.getTrainingSessionsForDay(DayOfWeek.THURSDAY);
//
//        Assertions.assertEquals(2, thursdaySessions.size());
//
//        Assertions.assertEquals(13,
//                thursdaySessions.get(0).getTimeOfDay().getHours());
//
//        Assertions.assertEquals(20,
//                thursdaySessions.get(1).getTimeOfDay().getHours());
//
//        Assertions.assertEquals(
//                0,
//                timetable.getTrainingSessionsForDay(DayOfWeek.TUESDAY).size()
//        );
//    }
//
//    @Test
//    void testGetTrainingSessionsForDayAndTime() {
//        Timetable timetable = new Timetable();
//
//        Group group = new Group("Акробатика для детей", Age.CHILD, 60);
//        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");
//
//        TrainingSession singleTrainingSession = new TrainingSession(
//                group,
//                coach,
//                DayOfWeek.MONDAY,
//                new TimeOfDay(13, 0)
//        );
//
//        timetable.addNewTrainingSession(singleTrainingSession);
//
//        Assertions.assertEquals(
//                1,
//                timetable.getTrainingSessionsForDayAndTime(
//                        DayOfWeek.MONDAY,
//                        new TimeOfDay(13, 0)
//                ).size()
//        );
//
//        Assertions.assertEquals(
//                0,
//                timetable.getTrainingSessionsForDayAndTime(
//                        DayOfWeek.MONDAY,
//                        new TimeOfDay(14, 0)
//                ).size()
//        );
//    }
//
//    @Test
//    void testMultipleSessionsSameTime() {
//        Timetable timetable = new Timetable();
//
//        Coach coach = new Coach("Иванов", "Иван", "Иванович");
//
//        Group g1 = new Group("Группа1", Age.CHILD, 60);
//        Group g2 = new Group("Группа2", Age.CHILD, 60);
//
//        timetable.addNewTrainingSession(
//                new TrainingSession(g1, coach,
//                        DayOfWeek.MONDAY, new TimeOfDay(10, 0))
//        );
//
//        timetable.addNewTrainingSession(
//                new TrainingSession(g2, coach,
//                        DayOfWeek.MONDAY, new TimeOfDay(10, 0))
//        );
//
//        Assertions.assertEquals(
//                2,
//                timetable.getTrainingSessionsForDayAndTime(
//                        DayOfWeek.MONDAY,
//                        new TimeOfDay(10, 0)
//                ).size()
//        );
//    }
//
//    @Test
//    void testEmptyDay() {
//        Timetable timetable = new Timetable();
//
//        Assertions.assertEquals(
//                0,
//                timetable.getTrainingSessionsForDay(DayOfWeek.FRIDAY).size()
//        );
//    }
//
//    @Test
//    void testGetCountByCoaches() {
//
//        Timetable timetable = new Timetable();
//
//        Coach coach1 = new Coach("Иванов", "Иван", "Иванович");
//        Coach coach2 = new Coach("Петров", "Петр", "Петрович");
//
//        Group group = new Group("Акробатика", Age.CHILD, 60);
//
//        timetable.addNewTrainingSession(
//                new TrainingSession(group, coach1,
//                        DayOfWeek.MONDAY, new TimeOfDay(10, 0)));
//
//        timetable.addNewTrainingSession(
//                new TrainingSession(group, coach1,
//                        DayOfWeek.TUESDAY, new TimeOfDay(10, 0)));
//
//        timetable.addNewTrainingSession(
//                new TrainingSession(group, coach2,
//                        DayOfWeek.WEDNESDAY, new TimeOfDay(10, 0)));
//
//        List<Map.Entry<Coach, Integer>> result =
//                timetable.getCountByCoaches();
//
//        Assertions.assertEquals(2, result.get(0).getValue());
//        Assertions.assertEquals(1, result.get(1).getValue());
//    }
//}