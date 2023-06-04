package com.course.schedule.repositories;

import com.course.schedule.models.Schedule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
    List<Schedule> findByTeam1ContainingIgnoreCaseOrTeam2ContainingIgnoreCase(String team1, String team2);
}