package dev.fastcleanapi.fastcleanapi.repository;

import dev.fastcleanapi.fastcleanapi.model.Login.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Login, Integer> {
    UserDetails findByEmail(String email);

}