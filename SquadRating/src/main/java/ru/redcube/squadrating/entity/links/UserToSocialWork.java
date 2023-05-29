package ru.redcube.squadrating.entity.links;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import ru.redcube.squadrating.entity.squadUser.SquadUser;
import ru.redcube.squadrating.entity.work.SocialWork;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_to_social_work")
public class UserToSocialWork extends UserToWork {

    @ManyToOne
    @JoinColumn(name = "work_id")
    private SocialWork work;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SquadUser user;
}
