package com.caneroksuz.repository;

import com.caneroksuz.repository.entity.UserInformation;
import com.caneroksuz.repository.entity.Users;
import com.caneroksuz.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserInformationRepository implements ICrud<UserInformation> {

    Session session;
    Transaction transaction;

    @Override
    public UserInformation save(UserInformation userInformation) {
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı..");
            transaction = session.beginTransaction();
            session.save(userInformation);
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

        return userInformation;

    }

    @Override
    public UserInformation update(UserInformation userInformation) {
        return null;
    }

    @Override
    public UserInformation deleteById(Long id) {
        return null;
    }

    @Override
    public List<UserInformation> findAll() {

        String hql="select ui from UserInformation ui";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<UserInformation> typedQuery = session.createQuery(hql, UserInformation.class);
        List<UserInformation> userInformations = typedQuery.getResultList();
        session.close();
        return userInformations;
    }

    @Override
    public Optional<UserInformation> findById(Long id) {
        return Optional.empty();
    }
}
