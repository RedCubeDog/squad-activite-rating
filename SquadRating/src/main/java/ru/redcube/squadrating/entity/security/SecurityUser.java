package ru.redcube.squadrating.entity.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "security_user")
public class SecurityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String roles;
    private boolean active;


//    @OneToOne(mappedBy = "securityUser",
//            cascade = CascadeType.ALL)
//    private SquadUser squadUser;

//    @ElementCollection(targetClass = SecurityRole.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<SecurityRole> roles = new HashSet<>();
}
