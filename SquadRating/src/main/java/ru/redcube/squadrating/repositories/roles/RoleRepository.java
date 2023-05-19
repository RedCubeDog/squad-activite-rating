package ru.redcube.squadrating.repositories.roles;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.configs.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role getRoleByName(String name);
}
