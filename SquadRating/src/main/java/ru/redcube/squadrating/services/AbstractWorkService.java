package ru.redcube.squadrating.services;


import ru.redcube.squadrating.entity.Work;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractWorkService implements WorkService {

    protected List<Work> works;

    public List<Work> getWorks() {
        return works;
    }

    public Work getWorkById(Long id) {
        List<Work> found =
                works.stream().filter(work -> work.getId() == id).collect(Collectors.toList());
        return found.size() == 0 ? null : found.stream().findFirst().get();
    }

    public void saveWork(String title) {

    }
}
