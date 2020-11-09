package com.vocabsvc.wordtrainer.repository;

import com.vocabsvc.wordtrainer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
