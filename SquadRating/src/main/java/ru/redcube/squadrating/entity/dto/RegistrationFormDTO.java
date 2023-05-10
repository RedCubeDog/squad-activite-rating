package ru.redcube.squadrating.entity.dto;

import ru.redcube.squadrating.configs.entities.User;
import ru.redcube.squadrating.entity.user.SquadUser;

public class RegistrationFormDTO {

    private User securityUser;
    private SquadUser squadUser;

    public RegistrationFormDTO(User securityUser, SquadUser squadUser) {
        this.securityUser = securityUser;
        this.squadUser = squadUser;
    }

    public User getSecurityUser() {
        return securityUser;
    }

    public void setSecurityUser(User securityUser) {
        this.securityUser = securityUser;
    }

    public SquadUser getSquadUser() {
        return squadUser;
    }

    public void setSquadUser(SquadUser squadUser) {
        this.squadUser = squadUser;
    }

    @Override
    public String toString() {
        return "RegistrationForm{" +
                "securityUser=" + securityUser +
                ", squadUser=" + squadUser +
                '}';
    }
}
