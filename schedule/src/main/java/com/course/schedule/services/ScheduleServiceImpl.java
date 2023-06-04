package com.course.schedule.services;

import com.course.schedule.models.Schedule;
import com.course.schedule.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

    @Override
    public void saveSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(long id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public Optional<Schedule> findPostById(long id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public List<Schedule> searchSchedules(String team) {
        return scheduleRepository.findByTeam1ContainingIgnoreCaseOrTeam2ContainingIgnoreCase(team, team);
    }
}