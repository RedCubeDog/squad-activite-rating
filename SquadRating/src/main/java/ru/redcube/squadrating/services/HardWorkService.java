package ru.redcube.squadrating.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.dao.HardWorkDAO;
import ru.redcube.squadrating.entity.work.HardWork;

import java.util.List;

@Service
public class HardWorkService {
    private final HardWorkDAO hardWorkDAO;

    @Autowired
    public HardWorkService(HardWorkDAO hardWorkDAO) {
        this.hardWorkDAO = hardWorkDAO;
    }

    public List<HardWork> getHardWorks() {
        return hardWorkDAO.findAll();
    }
}
