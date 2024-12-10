package com.innovatech.authentication.internal.queryservices;

import org.springframework.stereotype.Service;
import com.innovatech.authentication.domain.model.aggregates.User;
import com.innovatech.authentication.domain.model.queries.GetAllUsersQuery;
import com.innovatech.authentication.domain.model.queries.GetUserByIdQuery;
import com.innovatech.authentication.domain.model.queries.GetUserByUsernameQuery;
import com.innovatech.authentication.domain.services.UserQueryService;
import com.innovatech.authentication.infrastructure.persistence.jpa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.userId());
    }

    @Override
    public Optional<User> handle(GetUserByUsernameQuery query) {
        return userRepository.findByUsername(query.username());
    }
}
