package com.course.schedule.controllers;

import com.course.schedule.models.Schedule;
import com.course.schedule.services.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyController {

    private final ScheduleService scheduleService;

    public MyController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    @GetMapping("/")

    public String home(Model model) {
        model.addAttribute("title", "Головна");
        return "main";
    }

    @GetMapping("/company")
    public String company(Model model) {
        model.addAttribute("title", "Про нас");
        return "company";
    }

    @GetMapping("/schedule")
    public String schedule(Model model) {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        model.addAttribute("schedules", schedules);
        return "schedule";
    }

    @GetMapping("/search")
    public String sportSearch(@RequestParam(name = "team") String team, Model model) {
        List<Schedule> schedules = scheduleService.searchSchedules(team);
        model.addAttribute("schedules", schedules);
        return "schedule";
    }
}