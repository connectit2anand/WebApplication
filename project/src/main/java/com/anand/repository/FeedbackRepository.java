package com.anand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

}
