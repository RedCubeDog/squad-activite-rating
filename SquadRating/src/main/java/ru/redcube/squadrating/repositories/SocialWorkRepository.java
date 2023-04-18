package ru.redcube.squadrating.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.work.SocialWork;

public interface SocialWorkRepository extends JpaRepository<SocialWork, Long> {
}
