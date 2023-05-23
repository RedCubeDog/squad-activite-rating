package ru.redcube.squadrating.services.links;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.redcube.squadrating.entity.links.UserToHardWork;
import ru.redcube.squadrating.entity.links.UserToSocialWork;
import ru.redcube.squadrating.entity.work.HardWork;
import ru.redcube.squadrating.repositories.links.UserToHardWorkDAO;
import ru.redcube.squadrating.repositories.links.UserToSocialWorkDAO;

import java.util.List;
import java.util.Optional;

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
    @Transactional
    public Optional<UserToHardWork> getUserToHardWorkById(Long id) {
        return userToHardWorkDAO.findById(id);
    }
    @Transactional
    public void saveUserToHardWork(UserToHardWork userToHardWork) {
        userToHardWorkDAO.save(userToHardWork);
    }

    @Transactional
    public void deleteUserToHardWork(Long id) {
        userToHardWorkDAO.deleteById(id);
    }

    public void saveUserToSocialWork(UserToSocialWork userToSocialWork) {
        userToSocialWorkDAO.save(userToSocialWork);
    }

    @Transactional
    public void updateUserToHardWork(UserToHardWork userToHardWork, Long id) {
        Optional<UserToHardWork> userToHardWorkOptional = userToHardWorkDAO.findById(id);

        if (userToHardWorkOptional.isPresent()) {
            UserToHardWork userToHardWorkEntity = userToHardWorkOptional.get();
            userToHardWorkEntity.setWork(userToHardWork.getWork());
            userToHardWorkEntity.setTimeOfWork(userToHardWork.getTimeOfWork());
            userToHardWorkEntity.setUser(userToHardWork.getUser());
        }
    }


    @Transactional
    public Optional<UserToHardWork> getUserToHardWorkById(Long id) {
        return userToHardWorkDAO.findById(id);
    }

    @Transactional
    public void saveUserToHardWork(UserToHardWork userToHardWork) {
        userToHardWorkDAO.save(userToHardWork);
    }

    @Transactional
    public void deleteUserToHardWork(Long id) {
        userToHardWorkDAO.deleteById(id);
    }

    public void saveUserToSocialWork(UserToSocialWork userToSocialWork) {
        userToSocialWorkDAO.save(userToSocialWork);
    }

    @Transactional
    public void updateUserToHardWork(UserToHardWork userToHardWork, Long id) {
        Optional<UserToHardWork> userToHardWorkOptional = userToHardWorkDAO.findById(id);

        if (userToHardWorkOptional.isPresent()) {
            UserToHardWork userToHardWorkEntity = userToHardWorkOptional.get();
            userToHardWorkEntity.setWork(userToHardWork.getWork());
            userToHardWorkEntity.setTimeOfWork(userToHardWork.getTimeOfWork());
            userToHardWorkEntity.setUser(userToHardWork.getUser());
        }
    }


}
