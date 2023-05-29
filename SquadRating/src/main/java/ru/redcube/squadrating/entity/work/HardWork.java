package ru.redcube.squadrating.entity.work;

import jakarta.persistence.*;
import ru.redcube.squadrating.entity.squadUser.SquadUser;

import java.util.List;

@Entity
@Table(name = "hard_work")
public class HardWork extends AbstractWork {

    @ManyToMany
    @JoinTable(
            name = "user_to_hard_work",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<SquadUser> users;
}
