package ru.redcube.squadrating.entity.squad;

import jakarta.persistence.*;
import lombok.*;
import ru.redcube.squadrating.entity.user.User;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "squad")
public class SquadImpl implements Squad{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @OneToMany
    @Column(name = "squad_id")
    private List<User> users;
}
