package ru.redcube.squadrating.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.dao.UserToHardWorkDAO;
import ru.redcube.squadrating.dao.UserToSocialWorkDAO;
import ru.redcube.squadrating.entity.links.UserToHardWork;
import ru.redcube.squadrating.entity.links.UserToSocialWork;
import ru.redcube.squadrating.entity.work.HardWork;

import java.util.List;

@Service
public class UserToWorkService {
    private final UserToHardWorkDAO userToHardWorkDAO;
    private final UserToSocialWorkDAO userToSocialWorkDAO;

    @Autowired
    public UserToWorkService(UserToHardWorkDAO userToHardWorkDAO, UserToSocialWorkDAO userToSocialWorkDAO) {
        this.userToHardWorkDAO = userToHardWorkDAO;
        this.userToSocialWorkDAO = userToSocialWorkDAO;
    }

    public List<UserToSocialWork> getUserToSocialWorks() {
        return userToSocialWorkDAO.findAll();
    }
    public List<UserToHardWork> getUserToHardWorks() {
        return userToHardWorkDAO.findAll();
    }

}
