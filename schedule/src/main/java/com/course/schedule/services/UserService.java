package com.course.schedule.services;

import com.course.schedule.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
        void save(User user);
        User findByUsername(String username);
}