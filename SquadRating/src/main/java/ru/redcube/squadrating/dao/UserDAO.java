package ru.redcube.squadrating.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.User;

public interface UserDAO extends JpaRepository<User,Long> {

}
