package ru.redcube.squadrating.entity;

public abstract class AbstractWork implements Work {
    protected Long id;
    protected String title;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
