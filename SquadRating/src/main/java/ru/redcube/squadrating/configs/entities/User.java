package ru.redcube.squadrating.configs.entities;

import jakarta.persistence.*;
import lombok.*;
import ru.redcube.squadrating.configs.Role;
import ru.redcube.squadrating.entity.user.SquadUser;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mg_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean active;
    @OneToOne(mappedBy = "securityUser",
            cascade = CascadeType.ALL)
    private SquadUser squadUser;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();
}
