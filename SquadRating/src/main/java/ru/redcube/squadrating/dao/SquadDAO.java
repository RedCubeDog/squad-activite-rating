package ru.redcube.squadrating.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.user.User;

public interface SquadDAO extends JpaRepository<User,Long> {
}
