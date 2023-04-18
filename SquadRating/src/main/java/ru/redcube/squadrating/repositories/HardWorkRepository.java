package ru.redcube.squadrating.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.work.HardWork;

public interface HardWorkRepository extends JpaRepository<HardWork, Long> {
}
