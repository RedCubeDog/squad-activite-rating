package ru.redcube.squadrating.services;

import org.springframework.stereotype.Service;
import ru.redcube.squadrating.entity.HardWork;
import ru.redcube.squadrating.entity.SocialWork;


import java.util.ArrayList;

@Service
public class HardWorkService extends AbstractWorkService {

    public HardWorkService() {

        works = new ArrayList<>();
        works.add(new HardWork());
        works.add(new SocialWork());

    }
}
