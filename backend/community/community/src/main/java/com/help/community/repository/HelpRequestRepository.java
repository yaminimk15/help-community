package com.help.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.help.community.model.HelpRequest;

public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {
}