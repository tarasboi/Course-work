package com.course.schedule.controllers;

import com.course.schedule.models.Schedule;
import com.course.schedule.models.Results;
import com.course.schedule.services.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Controller
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedule/sport/add")
    public String sportAdd(@ModelAttribute("schedule") Schedule schedule) {
        return "add";
    }

    @PostMapping("/schedule/sport/add")
    public String sportPostAdd(@ModelAttribute("schedule") @Valid Schedule schedule,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "add";

        Results result = new Results(schedule.getResult1(), schedule.getResult2());
        schedule.setResult(result);
        scheduleService.saveSchedule(schedule);
        return "redirect:/schedule";
    }

    @GetMapping("/schedule/{id}")
    public String sportInfo(@PathVariable(value = "id") long id, Model model) {
        Optional<Schedule> schedule = scheduleService.findPostById(id);
        if (schedule.isEmpty()) {
            return "redirect:/schedule";
        }
        model.addAttribute("schedule", schedule.get());
        return "info";
    }

    @GetMapping("/schedule/{id}/edit")
    public String sportGetUpdate(Model model, @PathVariable("id") long id) {
        Optional<Schedule> schedule = scheduleService.findPostById(id);
        if (schedule.isEmpty()) {
            return "redirect:/schedule";
        }
        model.addAttribute("schedule", schedule.get());
        return "edit";
    }

    @PostMapping("/schedule/{id}/edit")
    public String sportPostUpdate(@ModelAttribute("schedule") @Valid Schedule schedule, BindingResult bindingResult,
                                  @PathVariable("id") long id, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "edit";
        }

        Results result = new Results(schedule.getResult1(), schedule.getResult2());
        schedule.setResult(result);
        scheduleService.saveSchedule(schedule);
        return "redirect:/schedule/{id}";
    }

    @PostMapping("/schedule/{id}/remove")
    public String sportPostRemove(@PathVariable(value = "id") long id, Model model) {
        Schedule schedule = scheduleService.findPostById(id).orElseThrow();
        scheduleService.deleteSchedule(id);
        return "redirect:/schedule";
    }
}
