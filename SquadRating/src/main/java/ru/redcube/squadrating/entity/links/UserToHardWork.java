package ru.redcube.squadrating.entity.links;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import ru.redcube.squadrating.entity.converters.DurationAttributeConverter;
import ru.redcube.squadrating.entity.squadUser.SquadUser;
import ru.redcube.squadrating.entity.work.HardWork;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_to_hard_work")
public class UserToHardWork extends UserToWork {

    @ManyToOne
    @JoinColumn(name = "work_id")
    private HardWork work;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SquadUser user;

    public Duration convertTimeToDuration(Time time) {
        LocalTime localTime = time.toLocalTime();
        long hours = localTime.getHour();
        long minutes = localTime.getMinute();

        return Duration.ofHours(hours).plusMinutes(minutes);
    }

    public void setTimeOfWork(String timeOfWork) {
        super.setTimeOfWork(new DurationAttributeConverter()
                .convertToEntityAttribute(timeOfWork));
    }
}
