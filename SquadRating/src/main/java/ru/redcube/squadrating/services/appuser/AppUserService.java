package ru.redcube.squadrating.services.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.entity.user.SquadRole;
import ru.redcube.squadrating.entity.user.SquadUser;
import ru.redcube.squadrating.repositories.user.AppUserRepository;

import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public void addUser(SquadUser user) {
        user.setSquadRole(SquadRole.CANDIDATE);
        appUserRepository.save(user);
    }

    public List<SquadUser> getUsers() {
        return appUserRepository.findAll();
    }
}
