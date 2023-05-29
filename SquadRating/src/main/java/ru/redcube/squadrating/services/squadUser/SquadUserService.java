package ru.redcube.squadrating.services.squadUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.repositories.squadUser.SquadUserRepository;
import ru.redcube.squadrating.entity.squadUser.SquadUser;

import java.util.List;

@Service
public class SquadUserService {

    private final SquadUserRepository squadUserRepository;

    @Autowired
    public SquadUserService(SquadUserRepository squadUserRepository) {
        this.squadUserRepository = squadUserRepository;
    }

    public List<SquadUser> getUsers() {
        return squadUserRepository.findAll();
    }
}
