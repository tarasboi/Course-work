package com.course.schedule.controllers;


import com.course.schedule.models.Role;
import com.course.schedule.models.User;
import com.course.schedule.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegController {

    private final UserService userService;

    public RegController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/reg")
    public String registration() {
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userService.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.put("error", " Таке ім'я вже використовується!");
            return "reg";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ADMIN));
        userService.save(user);

        return "redirect:/login";
    }
}
