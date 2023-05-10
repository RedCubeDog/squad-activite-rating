package ru.redcube.squadrating.services.work;

import ru.redcube.squadrating.entity.work.AbstractWork;

import java.util.List;
import java.util.Optional;

public interface WorkService<T extends AbstractWork> {

    default List<T> getAllWorks() {
        return null;
    }

    Optional<T> getWorkById(Long id);

    void saveWork(T work);
    void updateWork(T work, Long id);

    void deleteWork(Long id);

}
