package ru.redcube.squadrating.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.security.SecurityUser;

import java.util.Optional;

public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {

    Optional<SecurityUser> findByUsername(String username);
}
