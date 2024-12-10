package com.innovatech.authentication.domain.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import com.innovatech.authentication.domain.model.aggregates.User;
import com.innovatech.authentication.domain.model.commands.DeleteUserCommand;
import com.innovatech.authentication.domain.model.commands.SignInCommand;
import com.innovatech.authentication.domain.model.commands.SignUpCommand;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(SignUpCommand command);
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
    Optional<User> handle(DeleteUserCommand command);
}
