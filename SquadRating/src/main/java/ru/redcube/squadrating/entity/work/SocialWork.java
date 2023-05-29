package ru.redcube.squadrating.entity.work;

import jakarta.persistence.*;
import ru.redcube.squadrating.entity.squadUser.SquadUser;

import java.util.List;

@Entity
@Table(name = "social_work")
public class SocialWork extends AbstractWork {

    @ManyToMany
    @JoinTable(
            name = "user_to_social_work",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<SquadUser> users;
}
