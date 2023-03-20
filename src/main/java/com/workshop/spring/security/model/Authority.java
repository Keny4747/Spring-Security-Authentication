package com.workshop.spring.security.model;

import com.workshop.spring.security.utils.AuthorityName;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name ="authorities")
@Data
@NoArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    public Authority(AuthorityName authorityName){
        this.name = authorityName;
    }

}
