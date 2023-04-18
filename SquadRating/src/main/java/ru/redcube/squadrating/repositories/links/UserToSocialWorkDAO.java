package ru.redcube.squadrating.repositories.links;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.links.UserToSocialWork;

public interface UserToSocialWorkDAO extends JpaRepository<UserToSocialWork,Long> {
}
