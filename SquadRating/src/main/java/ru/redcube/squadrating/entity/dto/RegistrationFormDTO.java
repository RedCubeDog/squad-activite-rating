package ru.redcube.squadrating.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.redcube.squadrating.entity.security.SecurityUser;
import ru.redcube.squadrating.entity.squadUser.SquadUser;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationFormDTO {

    private SecurityUser securityUser;
    private SquadUser squadUser;
}
