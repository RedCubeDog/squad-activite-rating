package ru.redcube.squadrating.services.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.redcube.squadrating.repositories.work.HardWorkRepository;
import ru.redcube.squadrating.entity.work.HardWork;

import java.util.List;

@Service
public class HardWorkService implements WorkService<HardWork> {
    private final HardWorkRepository hardWorkRepository;

    @Autowired
    public HardWorkService(HardWorkRepository hardWorkRepository) {
        this.hardWorkRepository = hardWorkRepository;
    }


    @Transactional
    @Override
    public List<HardWork> getAllWorks() {
        return hardWorkRepository.findAll();
    }

    @Transactional
    @Override
    public HardWork getWork(Long id) {
        return hardWorkRepository.getReferenceById(id);
    }

    @Transactional
    @Override
    public void deleteWork(Long id) {
        hardWorkRepository.delete(getWork(id));
    }

    @Transactional
    @Override
    public void saveWork(HardWork hardWork) {
        hardWorkRepository.save(hardWork);
    }

}
