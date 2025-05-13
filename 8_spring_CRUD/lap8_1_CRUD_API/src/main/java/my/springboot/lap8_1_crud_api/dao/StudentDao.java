package my.springboot.lap8_1_crud_api.dao;

import my.springboot.lap8_1_crud_api.entities.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> findAll();

    public Student findById(int id);

    public Student save(Student student);

    public Student saveAndFlush(Student student);

    public void deleteById(int id);

    public void delete(Student student);
}
