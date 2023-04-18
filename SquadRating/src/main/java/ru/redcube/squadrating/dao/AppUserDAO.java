package ru.redcube.squadrating.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.user.AppUser;

public interface AppUserDAO extends JpaRepository<AppUser, Long> {

}
