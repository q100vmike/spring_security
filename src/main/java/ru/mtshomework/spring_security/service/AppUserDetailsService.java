package ru.mtshomework.spring_security.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mtshomework.spring_security.entity.AppUser;
import ru.mtshomework.spring_security.repository.AppUserRepository;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Service
public class AppUserDetailsService implements UserDetailsService {

    AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUserRepositoryByUsername = appUserRepository.findByUsername(username);

        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(() -> "read");
            }

            @Override
            public String getPassword() {
                return appUserRepositoryByUsername.getPassword();
            }

            @Override
            public String getUsername() {
                return appUserRepositoryByUsername.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }
        };

        return userDetails;
    }
}
