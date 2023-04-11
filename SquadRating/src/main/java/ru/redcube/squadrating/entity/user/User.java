package ru.redcube.squadrating.entity.user;

import jakarta.persistence.*;
import lombok.*;
import ru.redcube.squadrating.entity.work.HardWork;
import ru.redcube.squadrating.entity.work.SocialWork;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String squadId;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String login;
    private String email;
    @Enumerated(EnumType.STRING)
    private SquadRole squadRole;
    @Enumerated(EnumType.STRING)
    private UserState state;

    @ManyToMany(mappedBy = "users")
    private List<HardWork> hardWorks;

    @ManyToMany(mappedBy = "users")
    private List<SocialWork> socialWorks;
}
