package ru.yandex.practicum.gym;

import java.util.*;

public class Timetable {

    private Map<DayOfWeek, TreeMap<TimeOfDay, List<TrainingSession>>> timetable = new HashMap<>();


    public void addNewTrainingSession(TrainingSession trainingSession) {

        DayOfWeek day = trainingSession.getDayOfWeek();
        TimeOfDay time = trainingSession.getTimeOfDay();

        timetable.putIfAbsent(day, new TreeMap<>());

        TreeMap<TimeOfDay, List<TrainingSession>> dayMap = timetable.get(day);

        dayMap.putIfAbsent(time, new ArrayList<>());

        dayMap.get(time).add(trainingSession);
    }


    public List<TrainingSession> getTrainingSessionsForDay(DayOfWeek dayOfWeek) {

        TreeMap<TimeOfDay, List<TrainingSession>> dayMap = timetable.get(dayOfWeek);

        if (dayMap == null) {
            return new ArrayList<>();
        }

        List<TrainingSession> result = new ArrayList<>();

        for (List<TrainingSession> sessions : dayMap.values()) {
            result.addAll(sessions);
        }

        return result;
    }


    public List<TrainingSession> getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {

        TreeMap<TimeOfDay, List<TrainingSession>> dayMap = timetable.get(dayOfWeek);

        if (dayMap == null) {
            return new ArrayList<>();
        }

        return dayMap.getOrDefault(timeOfDay, new ArrayList<>());
    }


    public List<Map.Entry<Coach, Integer>> getCountByCoaches() {

        Map<Coach, Integer> counter = new HashMap<>();

        for (TreeMap<TimeOfDay, List<TrainingSession>> day : timetable.values()) {

            for (List<TrainingSession> sessions : day.values()) {

                for (TrainingSession session : sessions) {

                    Coach coach = session.getCoach();

                    counter.put(coach, counter.getOrDefault(coach, 0) + 1);
                }
            }
        }

        List<Map.Entry<Coach, Integer>> result = new ArrayList<>(counter.entrySet());

        result.sort((a, b) -> b.getValue() - a.getValue());

        return result;
    }
}