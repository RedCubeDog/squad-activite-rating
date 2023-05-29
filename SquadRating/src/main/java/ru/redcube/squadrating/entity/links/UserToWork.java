package ru.redcube.squadrating.entity.links;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class UserToWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Time timeOfWork;
}
