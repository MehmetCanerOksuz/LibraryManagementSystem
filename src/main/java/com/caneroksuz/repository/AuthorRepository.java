package com.caneroksuz.repository;

import com.caneroksuz.repository.entity.Author;
import com.caneroksuz.repository.entity.Book;
import com.caneroksuz.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class AuthorRepository implements ICrud<Author> {

    Session session;
    Transaction transaction;

    @Override
    public Author save(Author author
    ) {
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı..");
            transaction = session.beginTransaction();
            session.save(author
            );
            transaction.commit();
            System.out.println("Kayıt başarılı...");

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            System.out.println("Kayıt başarısız..");
        } finally {
            System.out.println("Oturum kapandı...!!");

            session.close();

        }

        return author
                ;
    }

    @Override
    public Author update(Author author
    ) {
        return null;
    }

    @Override
    public Author deleteById(Long id) {
        return null;
    }

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.empty();
    }


}
