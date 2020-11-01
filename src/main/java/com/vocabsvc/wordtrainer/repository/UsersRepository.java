package com.vocabsvc.wordtrainer.repository;

import com.vocabsvc.wordtrainer.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
