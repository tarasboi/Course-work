package com.course.schedule.repositories;

import com.course.schedule.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByUsername(String name);
}
