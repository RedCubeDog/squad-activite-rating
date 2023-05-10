package ru.redcube.squadrating.services.work;

import com.sun.management.GarbageCollectionNotificationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.redcube.squadrating.repositories.work.HardWorkRepository;
import ru.redcube.squadrating.entity.work.HardWork;

import java.util.List;
import java.util.Optional;

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
    public Optional<HardWork> getWorkById(Long id) {
        return hardWorkRepository.findById(id);
    }

    @Transactional
    @Override
    public void saveWork(HardWork hardWork) {
        hardWorkRepository.save(hardWork);
    }

    @Transactional
    @Override
    public void updateWork(HardWork hardWork, Long id) {
        Optional<HardWork> hardWorkOptional = hardWorkRepository.findById(id);

        if (hardWorkOptional.isPresent()) {
            HardWork hardWorkEntity = hardWorkOptional.get();
            hardWorkEntity.setTitle(hardWork.getTitle());
            hardWorkEntity.setDate(hardWork.getDate());
            hardWorkEntity.setDescription(hardWork.getDescription());
            hardWorkEntity.setCoefficient(hardWork.getCoefficient());
        }
    }

    @Transactional
    @Override
    public void deleteWork(Long id) {
        hardWorkRepository.deleteById(id);
    }
}
