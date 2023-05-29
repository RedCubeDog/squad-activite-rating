package ru.redcube.squadrating.entity.dto;

import lombok.*;
import org.springframework.stereotype.Component;
import ru.redcube.squadrating.entity.converters.DurationAttributeConverter;
import ru.redcube.squadrating.entity.links.UserToHardWork;
import ru.redcube.squadrating.entity.links.UserToSocialWork;
import ru.redcube.squadrating.entity.links.UserToWork;
import ru.redcube.squadrating.entity.squad.SquadImpl;
import ru.redcube.squadrating.entity.squadUser.SquadUser;

import java.time.Duration;
import java.util.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component("squadAndHours")
public class SquadAndHoursDTO {

    private String squadName;
    private Duration hardWorkTime;
    private Duration socialWorkTime;

    public String getFormattedHardTimeWork() {
        return DurationAttributeConverter.getFormattedTimeWork(hardWorkTime);
    }

    public String getFormattedSocialTimeWork() {
        return DurationAttributeConverter.getFormattedTimeWork(socialWorkTime);
    }

    private static Map<SquadImpl, Duration> getSquadAndWorkingHours(
            List<? extends UserToWork> usersAndHardWorks) {
        Map<SquadImpl, Duration> squadAndWorkingHours = new HashMap<>();
        for (UserToWork userToWork : usersAndHardWorks) {
            SquadUser user;
            if (userToWork instanceof UserToHardWork) {
                user = ((UserToHardWork) userToWork).getUser();
            } else {
                user = ((UserToSocialWork) userToWork).getUser();
            }
            if (!squadAndWorkingHours.containsKey(user.getSquadId())) {
                squadAndWorkingHours.put(user.getSquadId(), Duration.ofHours(0));
            }

            squadAndWorkingHours.put(user.getSquadId(),
                    squadAndWorkingHours.get(user.getSquadId()).plus(userToWork.getTimeOfWork()));
        }
        return squadAndWorkingHours;
    }

    public static List<SquadAndHoursDTO> squadsAndHours(List<UserToHardWork> userToHardWorks,
                                                        List<UserToSocialWork> userToSocialWorks) {
        List<SquadAndHoursDTO> squadsAndHours = new ArrayList<>();
        Map<SquadImpl, Duration> squadAndHardWorkingHours
                = getSquadAndWorkingHours(userToHardWorks);
        Map<SquadImpl, Duration> squadAndSocialWorkingHours
                = getSquadAndWorkingHours(userToSocialWorks);

        appendDataOnTimeWorkingOut(squadAndHardWorkingHours,
                squadAndSocialWorkingHours, squadsAndHours);
        appendDataFromSquadDifferences(squadAndHardWorkingHours,
                squadAndSocialWorkingHours, squadsAndHours);
        return squadsAndHours;
    }

    private static void appendDataOnTimeWorkingOut(Map<SquadImpl, Duration> firstSquadAndWorkingHours,
                                                   Map<SquadImpl, Duration> secondSquadAndWorkingHours,
                                                   List<SquadAndHoursDTO> squadsAndHours) {
        for (Map.Entry<SquadImpl, Duration> entry
                : firstSquadAndWorkingHours.entrySet()) {
            Duration secondDuration = Duration.ZERO;
            if (secondSquadAndWorkingHours.containsKey(entry.getKey())) {
                secondDuration = secondSquadAndWorkingHours.get(entry.getKey());
            }
            squadsAndHours.add(new SquadAndHoursDTO(
                    entry.getKey().getName(),
                    entry.getValue(),
                    secondDuration));
        }
    }

    private static void appendDataFromSquadDifferences(Map<SquadImpl, Duration> squadAndHardWorkingHours,
                                                       Map<SquadImpl, Duration> squadAndSocialWorkingHours,
                                                       List<SquadAndHoursDTO> squadsAndHours) {
        Set<SquadImpl> differenceBetweenSecondAndFirstSquad
                = new HashSet<>(squadAndSocialWorkingHours.keySet());
        differenceBetweenSecondAndFirstSquad.removeAll(squadAndHardWorkingHours.keySet());

        for (SquadImpl squad
                : differenceBetweenSecondAndFirstSquad) {
            squadsAndHours.add(new SquadAndHoursDTO(
                    squad.getName(),
                    Duration.ZERO,
                    squadAndSocialWorkingHours.get(squad)
            ));
        }
    }
}
