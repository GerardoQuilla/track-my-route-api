package com.innovatech.authentication.domain.services;

import com.innovatech.authentication.domain.model.aggregates.User;
import com.innovatech.authentication.domain.model.queries.GetAllUsersQuery;
import com.innovatech.authentication.domain.model.queries.GetUserByIdQuery;
import com.innovatech.authentication.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);
}
