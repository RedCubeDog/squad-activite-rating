package ru.redcube.squadrating.services.work;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.redcube.squadrating.repositories.work.SocialWorkRepository;
import ru.redcube.squadrating.entity.work.SocialWork;


import java.util.List;
import java.util.Optional;

@Service
public class SocialWorkService implements WorkService<SocialWork> {

    private final SocialWorkRepository socialWorkRepository;

    @Autowired
    public SocialWorkService(SocialWorkRepository socialWorkRepository) {
        this.socialWorkRepository = socialWorkRepository;
    }

    @Transactional
    @Override
    public List<SocialWork> getAllWorks() {
        return socialWorkRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<SocialWork> getWorkById(Long id) {
        return socialWorkRepository.findById(id);
    }

    @Transactional
    @Override
    public void saveWork(SocialWork socialWork) {
        socialWorkRepository.save(socialWork);
    }

    @Transactional
    @Override
    public void updateWork(SocialWork socialWork, Long id) {
        Optional<SocialWork> socialWorkOptional = socialWorkRepository.findById(id);

        if (socialWorkOptional.isPresent()) {
            SocialWork socialWorkEntity = socialWorkOptional.get();
            socialWorkEntity.setTitle(socialWork.getTitle());
            socialWorkEntity.setDate(socialWork.getDate());
            socialWorkEntity.setDescription(socialWork.getDescription());
            socialWorkEntity.setCoefficient(socialWork.getCoefficient());
        }
    }

    @Transactional
    @Override
    public void deleteWork(Long id) {
        socialWorkRepository.deleteById(id);
    }
}
