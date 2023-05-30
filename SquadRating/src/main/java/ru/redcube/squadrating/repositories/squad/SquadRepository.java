package ru.redcube.squadrating.repositories.squad;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.squad.SquadImpl;

import java.util.Optional;

public interface SquadRepository extends JpaRepository<SquadImpl, Long> {
    Optional<SquadImpl> findById(Long id);
}
