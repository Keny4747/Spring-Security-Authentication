package com.workshop.spring.security.utils;

import com.workshop.spring.security.model.Authority;
import com.workshop.spring.security.model.User;
import com.workshop.spring.security.repository.AuthorityRepository;
import com.workshop.spring.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Runner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.authorityRepository.count()==0){
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.READ),
                    new Authority(AuthorityName.WRITE)
            ));
        }

        if(this.userRepository.count()==0){
            this.userRepository.saveAll(List.of(
                    new User("keny","12345",List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("alexandra","12345",List.of(this.authorityRepository.findByName(AuthorityName.READ).get())),
                    new User("majo","12345",List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get()))
            ));
        }
    }
}