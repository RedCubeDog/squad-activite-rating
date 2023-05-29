package ru.redcube.squadrating.repositories.squadUser;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.squadUser.SquadUser;

public interface SquadUserRepository extends JpaRepository<SquadUser, Long> {

}
