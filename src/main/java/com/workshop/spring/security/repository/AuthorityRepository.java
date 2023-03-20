package com.workshop.spring.security.repository;

import com.workshop.spring.security.model.Authority;
import com.workshop.spring.security.utils.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {

    Optional<Authority> findByName(AuthorityName name);
}
