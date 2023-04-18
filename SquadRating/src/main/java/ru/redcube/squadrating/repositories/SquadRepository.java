package ru.redcube.squadrating.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.squad.SquadImpl;

public interface SquadRepository extends JpaRepository<SquadImpl, Long> {
}
