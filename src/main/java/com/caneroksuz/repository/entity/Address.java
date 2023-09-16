package com.caneroksuz.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Embeddable
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String country;
    private String city;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "address")
    @Builder.Default
    @ToString.Exclude // ToString in dışında bırakıyoruz..
    private List<UserInformation> userInformations = new ArrayList<>();
}
