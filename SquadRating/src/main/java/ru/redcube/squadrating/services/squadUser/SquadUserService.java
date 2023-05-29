package ru.redcube.squadrating.services.squadUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.redcube.squadrating.repositories.squadUser.SquadUserRepository;
import ru.redcube.squadrating.entity.squadUser.SquadUser;

import java.util.List;
import java.util.Optional;

@Service
public class SquadUserService {

    private final SquadUserRepository squadUserRepository;

    @Autowired
    public SquadUserService(SquadUserRepository squadUserRepository) {
        this.squadUserRepository = squadUserRepository;
    }

    @Transactional
    public List<SquadUser> getAllUsers() {
        return squadUserRepository.findAll();
    }
    @Transactional
    public Optional<SquadUser> getSquadUserById(Long id) {
        return squadUserRepository.findById(id);
    }
}
