package com.innovatech.authentication.internal.queryservices;

import org.springframework.stereotype.Service;
import com.innovatech.authentication.domain.model.entities.Role;
import com.innovatech.authentication.domain.model.queries.GetAllRolesQuery;
import com.innovatech.authentication.domain.model.queries.GetRoleByNameQuery;
import com.innovatech.authentication.domain.services.RoleQueryService;
import com.innovatech.authentication.infrastructure.persistence.jpa.repositories.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;

    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> handle(GetRoleByNameQuery query) {
        return roleRepository.findByName(query.roleName());
    }
}
