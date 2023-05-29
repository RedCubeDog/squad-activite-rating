package ru.redcube.squadrating.entity.links;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.sql.ast.tree.expression.DurationUnit;
import ru.redcube.squadrating.entity.converters.DurationAttributeConverter;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;

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

    @Convert(converter = DurationAttributeConverter.class)
    @Column(name = "time_work")
    private Duration timeOfWork;

    public String getFormattedTimeWork() {
        return DurationAttributeConverter.getFormattedTimeWork(timeOfWork);
    }
}
