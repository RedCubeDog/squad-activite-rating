package ru.redcube.squadrating.entity.squadUser;

import jakarta.persistence.*;
import lombok.*;
import ru.redcube.squadrating.entity.security.SecurityUser;
import ru.redcube.squadrating.entity.squad.SquadImpl;
import ru.redcube.squadrating.entity.work.HardWork;
import ru.redcube.squadrating.entity.work.SocialWork;

import java.util.List;

/**
 * Сущность, отвечающая за данные пользователя для отображения в таблицах.
 * Хранит имя, фамилию, отчество, логин, почту, роль в отряде и состояние
 */
@Data
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
    private SecurityUser securityUser;

    @ManyToMany(mappedBy = "users",
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.REFRESH, CascadeType.MERGE},
            fetch = FetchType.EAGER)
    private List<HardWork> hardWorks;

    @ManyToMany(mappedBy = "users",
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.REFRESH, CascadeType.MERGE},
            fetch = FetchType.EAGER)
    private List<SocialWork> socialWorks;
}
