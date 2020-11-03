package com.vocabsvc.wordtrainer.service;

import com.vocabsvc.wordtrainer.model.Users;
import com.vocabsvc.wordtrainer.repository.UsersRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public Users createUser(Users user) {
        return usersRepository.save(user);
    }
}
