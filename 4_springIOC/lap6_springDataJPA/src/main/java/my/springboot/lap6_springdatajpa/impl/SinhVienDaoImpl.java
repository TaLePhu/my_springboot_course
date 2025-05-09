package my.springboot.lap6_springdatajpa.impl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import my.springboot.lap6_springdatajpa.dao.SinhVienDao;
import my.springboot.lap6_springdatajpa.entities.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
