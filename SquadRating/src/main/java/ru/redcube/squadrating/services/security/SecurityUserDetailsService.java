package ru.redcube.squadrating.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.entity.security.SecurityUser;
import ru.redcube.squadrating.repositories.security.SecurityUserRepository;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private SecurityUserRepository securityUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SecurityUser> optional = securityUserRepository.findByUsername(username);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return mapRolesToAuthorities(optional.get());
    }

    private static User mapRolesToAuthorities(SecurityUser securityUser) {
        return new User(securityUser.getUsername(), securityUser.getPassword(),
                Arrays
                        .stream(securityUser.getRoles().split(", "))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
    }

    public void addUser(SecurityUser securityUser) throws Exception {
        Optional<SecurityUser> userFromDb = securityUserRepository.findByUsername(securityUser.getUsername());
        if (userFromDb.isPresent()) {
            throw new Exception("user exists");
        }
        securityUser.setRoles("ROLE_BASIC_STATE");
        securityUser.setActive(true);
        // todo зашифровать, 43 минута
        securityUserRepository.save(securityUser);
    }
}
