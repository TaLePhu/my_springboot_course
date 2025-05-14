package my.springboot.lap8_1_crud_api.dao;

import my.springboot.lap8_1_crud_api.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "students")
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameNot(String lastName);
}
