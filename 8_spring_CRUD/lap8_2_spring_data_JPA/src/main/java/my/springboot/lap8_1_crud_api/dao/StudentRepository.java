package my.springboot.lap8_1_crud_api.dao;

import my.springboot.lap8_1_crud_api.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
