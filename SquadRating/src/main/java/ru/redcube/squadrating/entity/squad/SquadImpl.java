package ru.redcube.squadrating.entity.squad;

import jakarta.persistence.*;
import lombok.*;
import ru.redcube.squadrating.entity.user.AppUser;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "squad")
public class SquadImpl implements Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "squadId", cascade = CascadeType.ALL)
    private List<AppUser> users;
}
