package ru.redcube.squadrating.entity.links;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import ru.redcube.squadrating.entity.squadUser.SquadUser;
import ru.redcube.squadrating.entity.work.HardWork;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_to_hard_work")
public class UserToHardWork extends UserToWork {

    @ManyToOne
    @JoinColumn(name = "work_id")
    private HardWork work;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SquadUser user;
}
