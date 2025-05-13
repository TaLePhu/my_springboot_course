package my.springboot.lap8_1_crud_api.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import my.springboot.lap8_1_crud_api.dao.StudentDao;
import my.springboot.lap8_1_crud_api.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {


    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        String query = "SELECT s FROM Student s";
        return entityManager.createQuery(query, Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student saveAndFlush(Student student) {
        student = entityManager.merge(student);
        entityManager.flush();
        return student;
    }

    @Override
    public void deleteById(int id) {
        Student s = entityManager.find(Student.class, id);
        entityManager.remove(s);
    }

    @Override
    public void delete(Student student) {
        entityManager.remove(student);
    }
}
