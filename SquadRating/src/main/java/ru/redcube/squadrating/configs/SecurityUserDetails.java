package ru.redcube.squadrating.configs;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.redcube.squadrating.entity.security.SecurityUser;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SecurityUserDetails implements UserDetails {

    private final String name;
    private final String password;
    private final List<GrantedAuthority> authorities;
    private final Boolean active;

    public SecurityUserDetails(SecurityUser securityUser) {
        this.name = securityUser.getUsername();
        this.password = securityUser.getPassword();
        this.authorities = Arrays
                .stream(securityUser.getRoles().split(", "))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        this.active = securityUser.isActive();
//        this.authorities = mapRolesToAuthorities(securityUser.getRoles());
    }

//    private List<? extends GrantedAuthority> mapRolesToAuthorities(Set<SecurityRole> roles) {
//        List<SimpleGrantedAuthority> securityRoles = roles.stream()
//                .map(r -> new SimpleGrantedAuthority("ROLE " + r.name()))
//                .collect(Collectors.toList());
//        return securityRoles;
//    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
