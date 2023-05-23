package ru.redcube.squadrating.services.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.redcube.squadrating.repositories.user.AppUserRepository;
import ru.redcube.squadrating.entity.user.AppUser;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Transactional
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }
    @Transactional
    public Optional<AppUser> getAppUserById(Long id) {
        return appUserRepository.findById(id);
    }
}
