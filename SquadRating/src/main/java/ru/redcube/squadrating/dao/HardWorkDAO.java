package ru.redcube.squadrating.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.work.HardWork;

public interface HardWorkDAO extends JpaRepository<HardWork,Long> {
}
