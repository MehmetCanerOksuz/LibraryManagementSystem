package com.caneroksuz.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserInformation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String about;

    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Address> address;
}
