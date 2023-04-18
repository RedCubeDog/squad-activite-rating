package ru.redcube.squadrating.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.repositories.squad.SquadRepository;
import ru.redcube.squadrating.entity.squad.SquadImpl;

import java.util.List;

@Service
public class SquadService {

    private final SquadRepository squadRepository;

    @Autowired
    public SquadService(SquadRepository squadRepository) {
        this.squadRepository = squadRepository;
    }

    public List<SquadImpl> getSquads() {
        return squadRepository.findAll();
    }
}
