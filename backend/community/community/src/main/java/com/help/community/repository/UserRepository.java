package com.help.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.help.community.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}