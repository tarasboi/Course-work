package com.course.schedule.services;

import com.course.schedule.models.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    List<Schedule> getAllSchedules();

    void saveSchedule(Schedule post);

    void deleteSchedule(long id);

    Optional<Schedule> findPostById(long id);

    List<Schedule> searchSchedules(String team);
}