package ru.redcube.squadrating.services.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.repositories.work.HardWorkRepository;
import ru.redcube.squadrating.entity.work.HardWork;

import java.util.List;

@Service
public class HardWorkService {
    private final HardWorkRepository hardWorkRepository;

    @Autowired
    public HardWorkService(HardWorkRepository hardWorkRepository) {
        this.hardWorkRepository = hardWorkRepository;
    }

    public List<HardWork> getHardWorks() {
        return hardWorkRepository.findAll();
    }
}
