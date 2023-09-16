package com.caneroksuz;

import com.caneroksuz.controller.AuthorController;
import com.caneroksuz.controller.BookController;
import com.caneroksuz.repository.entity.Author;
import com.caneroksuz.repository.entity.Book;
import com.caneroksuz.repository.enums.EBookType;
import com.caneroksuz.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.dialect.H2Dialect;

import javax.persistence.TypedQuery;
import java.util.List;

public class MainOneToMany {

    public static void main(String[] args) {

        AuthorController authorController = new AuthorController();
        BookController bookController = new BookController();

        Author author = Author.builder().firstName("Kemal").lastName("Tahir").build();

        Book book1 = Book.builder().title("Hür Şehrin İnsanları").bookType(EBookType.HISTORY).author(author).build();
        Book book2 = Book.builder().title("Esir Şehrin İnsanları").bookType(EBookType.HISTORY).author(author).build();
        Book book3 = Book.builder().title("Yorgun Savaşçı").bookType(EBookType.HISTORY).author(author).build();

/*        author.setBooks(List.of(book1,book2,book3));

        authorController.save(author);*/


        bookController.save(book1);
        bookController.save(book2);
        bookController.save(book3);

        Session session = HibernateUtility.getSessionFactory().openSession();
        String hql = "SELECT a from Author AS a WHERE a.id=1";
        TypedQuery<Author> typedQuery = session.createQuery(hql, Author.class);
        Author newAuthor = typedQuery.getSingleResult();
        session.close();
        System.out.println(newAuthor.getFirstName());
        System.out.println(newAuthor.getBooks());



    }
}
