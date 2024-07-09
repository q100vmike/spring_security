package ru.mtshomework.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mtshomework.spring_security.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query("""
        select u from AppUser u where u.username = :username
        """)
    AppUser findByUsername(String username);
}
