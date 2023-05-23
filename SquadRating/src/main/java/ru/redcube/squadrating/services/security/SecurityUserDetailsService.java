package ru.redcube.squadrating.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.configs.SecurityUserDetails;
import ru.redcube.squadrating.entity.security.SecurityUser;
import ru.redcube.squadrating.repositories.security.SecurityUserRepository;

import java.util.Optional;

@Service
public class  SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private SecurityUserRepository securityUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SecurityUser> securityUser = securityUserRepository.findByUsername(username);
        return securityUser.map(SecurityUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
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
