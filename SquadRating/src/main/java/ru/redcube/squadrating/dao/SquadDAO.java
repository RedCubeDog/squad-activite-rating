package ru.redcube.squadrating.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.squad.SquadImpl;

public interface SquadDAO extends JpaRepository<SquadImpl, Long> {
}
