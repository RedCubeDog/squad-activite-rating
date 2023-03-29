package ru.redcube.squadrating.services;


import ru.redcube.squadrating.entity.Work;

import java.util.List;

public interface WorkService {

    List<Work> getWorks();

    Work getWorkById(Long id);

    void saveWork(String title);
}
