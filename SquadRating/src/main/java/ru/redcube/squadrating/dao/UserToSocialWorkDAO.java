package ru.redcube.squadrating.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.links.UserToSocialWork;
import ru.redcube.squadrating.entity.work.HardWork;

public interface UserToSocialWorkDAO extends JpaRepository<UserToSocialWork,Long> {
}
