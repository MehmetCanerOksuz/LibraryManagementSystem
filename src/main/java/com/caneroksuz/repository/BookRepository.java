package com.caneroksuz.repository;

import com.caneroksuz.repository.entity.Book;
import com.caneroksuz.repository.enums.EBookType;
import com.caneroksuz.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class BookRepository implements ICrud<Book> {

    Session session;
    Transaction transaction;

    @Override
    public Book save(Book book) {
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı..");
            transaction = session.beginTransaction();
            session.save(book);
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

        return book;
    }

    @Override
    public Book update(Book book) {
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            System.out.println("Oturum açıldı..");
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
            System.out.println("Güncelleme başarılı");
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            System.out.println("Güncelleme başarısız");
        } finally {
            System.out.println("Oturum kapandı...!!");
            session.close();
            return book;
        }
    }

    @Override
    public Book deleteById(Long id) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    public List<Book> getBooksByType(EBookType type) {
        String hql = "select b from Book b where b.bookType =:x";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);
        typedQuery.setParameter("x", type);
        List<Book> list = typedQuery.getResultList();
        session.close();
        return list;
    }


    public List<Book> getBooksByTypeNovel() {
        String hql = "select b from Book b where b.bookType ='NOVEL'";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);
        List<Book> list = typedQuery.getResultList();
        session.close();
        return list;
    }

    public List<Book> getBooksWithAuthorNameStartWith(String value) {
        String hql = "SELECT b FROM Book b where b.author.firstName LIKE  '" + value + "%'";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);
        List<Book> list = typedQuery.getResultList();
        session.close();
        return list;
    }


    public List<Book> getBooksByTypeNamedQuery(EBookType type) {

        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Book> typedQuery = session.createNamedQuery("findByBookType", Book.class);
        typedQuery.setParameter("myType", type);
        List<Book> list = typedQuery.getResultList();
        session.close();
        return list;
    }

    public Optional<Book> findByTitle(String title) {
        String hql = "select b from Book as b where b.title=:x";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);
        typedQuery.setParameter("x", title);
        Book book = null;
        try {
            book = typedQuery.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }
        return Optional.ofNullable(book);
    }


    public List<Book> findByTitle2(String title) {
        String hql = "select b from Book as b where b.title=:x";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Book> typedQuery = session.createQuery(hql, Book.class);
        typedQuery.setParameter("x", title);
        typedQuery.setMaxResults(1);
        List<Book> list = typedQuery.getResultList();
        session.close();
        return list;
    }

    public List<Object[]> getBooksCountByBookType(){
        String hql="SELECT b.bookType, COUNT(b) FROM Book b GROUP BY b.bookType";
        session = HibernateUtility.getSessionFactory().openSession();
        TypedQuery<Object[]> typedQuery = session.createQuery(hql,Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        session.close();
        return list;
    }






    //Criteria SORGULARI.....


    public List<Object[]> getBooksCountByBookTypeWithCriteria(){
        EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.multiselect(root.get("bookType"),criteriaBuilder.count(root)).groupBy(root.get("bookType"));
        List<Object[]> list = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return list;
    }
    public List<Book> findByTitleWithCriteria(String title) {
        EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("title"), title));
        List<Book> list = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return list;


    }

    public List<Object[]> findByTitleWithCriteria2(String title) {
        EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.multiselect(root.get("title"), root.get("author")).where(criteriaBuilder.equal(root.get("title"), title));
        List<Object[]> list = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return list;
    }

    public List<Book> getBooksByTypeWithCriteria(EBookType type) {
        EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("bookType"), type));
        List<Book> list = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return list;
    }




}
