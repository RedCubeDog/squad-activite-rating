package ru.redcube.squadrating.repositories.links;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redcube.squadrating.entity.links.UserToHardWork;

public interface UserToHardWorkDAO extends JpaRepository<UserToHardWork,Long> {
}
