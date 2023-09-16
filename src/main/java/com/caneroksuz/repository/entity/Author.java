package com.caneroksuz.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String firstName;

    private String lastName;
    //fetch default olarak LAZY ..
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER) // ara tablo oluşturmamak için..
        //ara tablo özelliklerini vermek için kullanılır..
/*    @JoinTable(name = "yazar_kitap",
    joinColumns = @JoinColumn(name = "kitap_id"),
    inverseJoinColumns = @JoinColumn(name = "yazar_id"))*/
    @ToString.Exclude
    List<Book> books;
}
