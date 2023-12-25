package com.seniorglez.start.application.useCase;

import com.seniorglez.start.application.annotation.Injectable;
import com.seniorglez.start.domain.model.User;
import com.seniorglez.start.infra.db.storer.UserStorer;

@Injectable
public class GetUserByCredentialsUseCase {

    private final UserStorer userStorer;

    public GetUserByCredentialsUseCase(UserStorer userStorer) {
        this.userStorer = userStorer;
    }

    public User execute(GetUserByCredentialsInput input) {
        return userStorer.findUserByUsernameAndPassword(
                input.getUsername(),
                input.getPassword()
        );
    }
}
