package ru.redcube.squadrating.entity.work;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractWork implements Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "title")
    protected String title;

    @Column(name = "description")
    protected String description;

    @Column(name = "date")
    private Date date;

    @Column(name = "coefficient")
    private Integer coefficient;

}
