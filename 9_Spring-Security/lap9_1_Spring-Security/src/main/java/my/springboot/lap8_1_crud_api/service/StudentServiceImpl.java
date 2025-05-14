package my.springboot.lap8_1_crud_api.service;

import my.springboot.lap8_1_crud_api.dao.StudentRepository;
import my.springboot.lap8_1_crud_api.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudentsNotFirstName(String name) {
        return studentRepository.findByFirstNameNot(name);
    }
}
