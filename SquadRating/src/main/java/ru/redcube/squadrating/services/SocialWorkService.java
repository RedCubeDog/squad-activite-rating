package ru.redcube.squadrating.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.repositories.SocialWorkRepository;
import ru.redcube.squadrating.entity.work.SocialWork;


import java.util.List;

@Service
public class SocialWorkService {

    private final SocialWorkRepository socialWorkRepository;

    @Autowired
    public SocialWorkService(SocialWorkRepository socialWorkRepository) {
        this.socialWorkRepository = socialWorkRepository;
    }

    public List<SocialWork> getSocialWorks() {
        return socialWorkRepository.findAll();
    }
}
