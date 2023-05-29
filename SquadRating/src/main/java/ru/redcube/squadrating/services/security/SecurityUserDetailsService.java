package ru.redcube.squadrating.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.entity.security.SecurityRole;
import ru.redcube.squadrating.entity.security.SecurityUser;
import ru.redcube.squadrating.repositories.security.SecurityUserRepository;
import ru.redcube.squadrating.repositories.squadUser.SquadUserRepository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Сервис, отвечающий за загрузку пользователей
 * при входе и за сохранение при регистрации
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final SecurityUserRepository securityUserRepository;

    @Autowired
    public SecurityUserDetailsService(SecurityUserRepository securityUserRepository) {
        this.securityUserRepository = securityUserRepository;
    }

    /**
     * <pre>
     * При входе загружает пользователя по его имени из БД.
     * Меппит его в Spring Security формат пользователя.
     * </pre>
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SecurityUser> myUser = securityUserRepository.findByUsername(username);
        if (myUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        SecurityUser securityUser = myUser.get();
        return new org.springframework.security.core.userdetails
                .User(securityUser.getUsername(), securityUser.getPassword(),
                mapRolesToAuthorities(securityUser.getRoles()));
    }

    /**
     * <pre>
     *     Мэппит роли пользователя из БД в формат GrantedAuthority,
     *     т.к. User из Spring Security работает в таком формате
     * </pre>
     *
     * @param roles
     * @return List<? extends GrantedAuthority>
     */
    private List<? extends GrantedAuthority> mapRolesToAuthorities(Set<SecurityRole> roles) {
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.name()))
                .collect(Collectors.toList());
    }

    /**
     * Добавление пользователя в БД при регистрации
     * @param securityUser
     * @throws Exception
     */
    public void addUser(SecurityUser securityUser) throws Exception {
        Optional<SecurityUser> userFromDb = securityUserRepository
                .findByUsername(securityUser.getUsername());
        if (userFromDb.isPresent()) {
            throw new Exception("user exists");
        }
        securityUser.setRoles(Collections.singleton(SecurityRole.BASIC_STATE));
        securityUser.setActive(true);
        // todo зашифровать, 43 минута
        securityUserRepository.save(securityUser);
    }
}
