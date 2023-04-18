package ru.redcube.squadrating.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.user.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

}
