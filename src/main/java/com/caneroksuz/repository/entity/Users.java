package com.caneroksuz.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true) // One to One ı bu şekilde sağladık..
    private UserInformation userInformation;


}
