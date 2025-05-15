package my.springboot.lap11_springmvc.dao;

import my.springboot.lap11_springmvc.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
