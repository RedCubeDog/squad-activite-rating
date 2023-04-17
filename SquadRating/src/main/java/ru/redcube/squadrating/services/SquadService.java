package ru.redcube.squadrating.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.dao.SquadDAO;
import ru.redcube.squadrating.entity.squad.SquadImpl;

import java.util.List;

@Service
public class SquadService {

    private final SquadDAO squadDAO;

    @Autowired
    public SquadService(SquadDAO squadDAO) {
        this.squadDAO = squadDAO;
    }

    public List<SquadImpl> getSquads() {
        return squadDAO.findAll();
    }
}
