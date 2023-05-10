package ru.redcube.squadrating.entity.links;

import jakarta.persistence.*;
import lombok.*;
import ru.redcube.squadrating.entity.converters.DurationAttributeConverter;

import java.time.Duration;

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
    private Duration timeWork;

    public String getFormattedTimeWork() {
        return DurationAttributeConverter.getFormattedTimeWork(timeWork);
    }
}
