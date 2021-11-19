package com.study.train.repo;

import com.study.train.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
