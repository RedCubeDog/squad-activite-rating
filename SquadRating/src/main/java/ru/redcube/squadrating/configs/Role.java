package ru.redcube.squadrating.configs;

import jakarta.persistence.*;
import lombok.*;
import ru.redcube.squadrating.configs.entities.User;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "role",
//            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
//                    CascadeType.REFRESH, CascadeType.MERGE})
//    private List<User> user;
}
