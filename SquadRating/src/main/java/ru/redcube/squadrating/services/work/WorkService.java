package ru.redcube.squadrating.services.work;

import ru.redcube.squadrating.entity.work.AbstractWork;

import java.util.List;

public interface WorkService<T extends AbstractWork> {
    default List<T> getAllWorks() {
        return null;
    }

    void saveWork(T work);

    T getWork(Long id);

    void deleteWork(Long id);
}
