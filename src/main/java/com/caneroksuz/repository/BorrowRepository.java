package com.caneroksuz.repository;

import com.caneroksuz.repository.entity.Borrow;
import com.caneroksuz.repository.entity.Users;
import com.caneroksuz.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class BorrowRepository implements ICrud<Borrow> {

    Session session;
    Transaction transaction;

    @Override
    public Borrow save(Borrow borrow
    ) {
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı..");
            transaction = session.beginTransaction();
            session.save(borrow
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

        return borrow
                ;
    }

    @Override
    public Borrow update(Borrow borrow) {
        return null;
    }

    @Override
    public Borrow deleteById(Long id) {
        return null;
    }

    @Override
    public List<Borrow> findAll() {
        return null;
    }

    @Override
    public Optional<Borrow> findById(Long id) {
        return Optional.empty();
    }

    public List<Borrow> getBorrowsByUser(Long userId){
        String hql="SELECT b FROM Borrow b WHERE b.users.id=:myId";
        session=HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Borrow> typedQuery = session.createQuery(hql, Borrow.class);
        typedQuery.setParameter("myId",userId);
        List<Borrow> list = typedQuery.getResultList();
        session.close();

        return list;
    }

    public List<Users> getUsersByBookId(Long bookId){
        String hql ="SELECT b.users FROM Borrow b WHERE b.book.id=:myId";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Users> typedQuery = session.createQuery(hql, Users.class);
        typedQuery.setParameter("myId",bookId);
        List<Users> list = typedQuery.getResultList();
        session.close();

        return list;
    }
}
