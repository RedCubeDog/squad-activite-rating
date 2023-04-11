package ru.redcube.squadrating.services;

import org.springframework.stereotype.Service;
import ru.redcube.squadrating.entity.work.HardWork;
import ru.redcube.squadrating.entity.work.SocialWork;


import java.util.ArrayList;

@Service
public class HardWorkService extends AbstractWorkService {

    public HardWorkService() {

        works = new ArrayList<>();
        works.add(new HardWork());
        works.add(new SocialWork());

    }
}
