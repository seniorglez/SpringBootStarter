package com.seniorglez.start.infra.db.storer;

import com.seniorglez.start.domain.model.User;
import com.seniorglez.start.infra.db.repository.UserRepository;
import com.seniorglez.start.infra.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserStorer {

    private final UserRepository userRepository;

    public UserStorer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        UserEntity entity = userRepository.findByUsername(username); //TODO: add password_hashed
        return entity.toModel();
    }
}
