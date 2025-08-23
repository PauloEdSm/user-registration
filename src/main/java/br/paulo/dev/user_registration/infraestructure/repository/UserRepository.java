package br.paulo.dev.user_registration.infraestructure.repository;

import br.paulo.dev.user_registration.infraestructure.entitys.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.Transient;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer> {
    Optional <User> findByEmail (String email);
    @Transactional
    void deleteByEmail (String email);
}
