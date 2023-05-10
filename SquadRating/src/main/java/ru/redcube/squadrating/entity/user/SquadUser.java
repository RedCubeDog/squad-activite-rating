package ru.redcube.squadrating.entity.user;

import jakarta.persistence.*;
import lombok.*;
import ru.redcube.squadrating.entity.squad.SquadImpl;
import ru.redcube.squadrating.entity.work.HardWork;
import ru.redcube.squadrating.entity.work.SocialWork;
import ru.redcube.squadrating.configs.entities.User;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "squad_user")
public class SquadUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "squad_id")
    private SquadImpl squadId;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    @Enumerated(EnumType.STRING)
    private SquadRole squadRole;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "security_id")
    private User securityUser;

    @ManyToMany(mappedBy = "users")
    private List<HardWork> hardWorks;

    @ManyToMany(mappedBy = "users")
    private List<SocialWork> socialWorks;
}
