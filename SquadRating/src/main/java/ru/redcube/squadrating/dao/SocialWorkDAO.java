package ru.redcube.squadrating.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.work.SocialWork;

public interface SocialWorkDAO extends JpaRepository<SocialWork, Long> {
}
