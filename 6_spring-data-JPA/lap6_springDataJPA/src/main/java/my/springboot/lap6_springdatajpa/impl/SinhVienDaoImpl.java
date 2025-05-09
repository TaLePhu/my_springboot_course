package my.springboot.lap6_springdatajpa.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import my.springboot.lap6_springdatajpa.dao.SinhVienDao;
import my.springboot.lap6_springdatajpa.entities.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SinhVienDaoImpl implements SinhVienDao {


    private EntityManager em;

    @Autowired
    public SinhVienDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(SinhVien sv) {
        this.em.persist(sv);
    }

    @Override
    public SinhVien findById(int id) {
        return this.em.find(SinhVien.class, id);
    }

    @Override
    public List<SinhVien> findAll() {
        String jpql = "SELECT s FROM SinhVien s";
        return this.em.createQuery(jpql, SinhVien.class).getResultList();
    }

    @Override
    public SinhVien findByTen(String ten) {
        String jpql = "SELECT s FROM SinhVien s WHERE s.ten = :ten";
        TypedQuery<SinhVien> query = this.em.createQuery(jpql, SinhVien.class);
        query.setParameter("ten", ten);
        return query.getSingleResult();
    }

    @Override
    public SinhVien update(SinhVien sv) {
        return this.em.merge(sv);
    }

    @Override
    public int updateAllTen(String ten) {
        String jpql = "UPDATE SinhVien s SET s.ten = :ten WHERE s.ten = :ten";
        Query query = this.em.createQuery(jpql, SinhVien.class);
        query.setParameter("ten", ten);

        return query.executeUpdate();
    }

    @Override
    public void deleteById(int id) {
        SinhVien sv = em.find(SinhVien.class, id);
        this.em.remove(sv);
    }
}
