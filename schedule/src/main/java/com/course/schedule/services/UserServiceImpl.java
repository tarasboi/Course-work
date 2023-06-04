package com.course.schedule.services;

import com.course.schedule.models.User;
import com.course.schedule.repositories.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}