package com.caneroksuz.repository;

import com.caneroksuz.repository.entity.Address;
import com.caneroksuz.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class AddressRepository implements ICrud<Address> {

    Session session;
    Transaction transaction;

    @Override
    public Address save(Address address) {
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı..");
            transaction = session.beginTransaction();
            session.save(address);
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

        return address;
    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Override
    public Address deleteById(Long id) {
        return null;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Optional<Address> findById(Long id) {
        return Optional.empty();
    }
}
