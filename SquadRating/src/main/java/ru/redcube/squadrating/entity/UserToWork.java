package ru.redcube.squadrating.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_to_work")
public class UserToWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "work_id")
    private Long workId;

    @Column(name = "user_id")
    private Long userId;

    public UserToWork() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
