package ru.redcube.squadrating.services.config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.redcube.squadrating.configs.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.redcube.squadrating.configs.entities.User;
import ru.redcube.squadrating.entity.user.SquadRole;
import ru.redcube.squadrating.repositories.config.UserRepository;
import ru.redcube.squadrating.repositories.roles.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myUser = userRepository.findByUsername(username);
        var user1 = new org.springframework.security.core.userdetails
                .User(myUser.getUsername(), myUser.getPassword(),
                mapRolesToAuthorities(myUser.getRoles()));
        return user1;
    }

    private List<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority("ROLE " + r.getName()))
                .collect(Collectors.toList());
    }

    public void addUser(User user) throws Exception {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            throw new Exception("user exists");
        }
        user.getSquadUser().setSquadRole(SquadRole.CANDIDATE);
        Role role = roleRepository.getRoleByName("BASIC_STATE");
        user.setRoles(new HashSet<>(List.of(role)));
        user.setActive(true);
        userRepository.save(user);
    }
}
