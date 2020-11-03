package com.vocabsvc.wordtrainer.repository;

import com.vocabsvc.wordtrainer.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
