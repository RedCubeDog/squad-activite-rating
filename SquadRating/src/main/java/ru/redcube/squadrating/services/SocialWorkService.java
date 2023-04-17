package ru.redcube.squadrating.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.dao.SocialWorkDAO;
import ru.redcube.squadrating.entity.work.SocialWork;


import java.util.List;
@Service
public class SocialWorkService {

    private final SocialWorkDAO socialWorkDAO;
    @Autowired
    public SocialWorkService(SocialWorkDAO socialWorkDAO) {
        this.socialWorkDAO = socialWorkDAO;
    }

    public List<SocialWork> getSocialWorks() {
        return socialWorkDAO.findAll();
    }
}
