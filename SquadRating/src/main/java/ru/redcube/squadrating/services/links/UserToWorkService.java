package ru.redcube.squadrating.services.links;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.redcube.squadrating.entity.converters.DurationAttributeConverter;
import ru.redcube.squadrating.entity.links.UserToHardWork;
import ru.redcube.squadrating.entity.links.UserToSocialWork;
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
    public Optional<UserToSocialWork> getUserToSocialWorkById(Long id) {
        return userToSocialWorkDAO.findById(id);
    }

    @Transactional
    public void saveUserToHardWork(UserToHardWork userToHardWork) {
        userToHardWork.setTimeOfWork(new DurationAttributeConverter()
                .convertToEntityAttribute(userToHardWork.getTimeOfWorkString()));
        userToHardWorkDAO.save(userToHardWork);
    }

    @Transactional
    public void deleteUserToHardWork(Long id) {
        userToHardWorkDAO.deleteById(id);
    }

    @Transactional
    public void deleteUserToSocialWork(Long id) {
        userToSocialWorkDAO.deleteById(id);
    }

    @Transactional
    public void saveUserToSocialWork(UserToSocialWork userToSocialWork) {
        userToSocialWork.setTimeOfWork(new DurationAttributeConverter()
                .convertToEntityAttribute(userToSocialWork.getTimeOfWorkString()));
        userToSocialWorkDAO.save(userToSocialWork);
    }

    @Transactional
    public void updateUserToHardWork(UserToHardWork userToHardWork, Long id) {
        Optional<UserToHardWork> userToHardWorkOptional = userToHardWorkDAO.findById(id);


        if (userToHardWorkOptional.isPresent()) {
            userToHardWork.setTimeOfWork(new DurationAttributeConverter()
                    .convertToEntityAttribute(userToHardWork.getTimeOfWorkString()));
            UserToHardWork userToHardWorkEntity = userToHardWorkOptional.get();
            userToHardWorkEntity.setWork(userToHardWork.getWork());
            userToHardWorkEntity.setTimeOfWork(userToHardWork.getTimeOfWork());
            userToHardWorkEntity.setUser(userToHardWork.getUser());
        }
    }

    @Transactional
    public void updateUserToSocialWork(UserToSocialWork userToSocialWork, Long id) {
        Optional<UserToSocialWork> userToSocialWorkOptional = userToSocialWorkDAO.findById(id);

        if (userToSocialWorkOptional.isPresent()) {
            userToSocialWork.setTimeOfWork(new DurationAttributeConverter()
                    .convertToEntityAttribute(userToSocialWork.getTimeOfWorkString()));
            UserToSocialWork userToSocialWorkEntity = userToSocialWorkOptional.get();
            userToSocialWorkEntity.setWork(userToSocialWork.getWork());
            userToSocialWorkEntity.setTimeOfWork(userToSocialWork.getTimeOfWork());
            userToSocialWorkEntity.setUser(userToSocialWork.getUser());
        }
    }


}
