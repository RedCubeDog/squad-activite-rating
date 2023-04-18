package ru.redcube.squadrating.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.dao.AppUserDAO;
import ru.redcube.squadrating.entity.user.AppUser;

import java.util.List;

@Service
public class UserService {

    private final AppUserDAO appUserDAO;

    @Autowired
    public UserService(AppUserDAO appUserDAO) {
        this.appUserDAO = appUserDAO;
    }

    public List<AppUser> getUsers() {
        return appUserDAO.findAll();
    }
}
