package com.caneroksuz.repository.entity;

import com.caneroksuz.repository.enums.EBookType;
import com.caneroksuz.repository.enums.EStatus;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@NamedQueries(
        {
          @NamedQuery(name = "findByBookType", query = "select b from Book b where b.bookType =:myType"),
          @NamedQuery(name = "findById", query = "select b from Book b where b.id =: myId")
        }
)
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private EBookType bookType;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status =EStatus.AVAILABLE;
    private int pageCount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "my_author_id", referencedColumnName = "id")
    //@ToString.Exclude
    private Author author;
}
