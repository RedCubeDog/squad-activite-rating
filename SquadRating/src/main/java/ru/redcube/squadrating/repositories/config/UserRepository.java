package ru.redcube.squadrating.repositories.config;

import org.springframework.data.repository.CrudRepository;
import ru.redcube.squadrating.configs.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
