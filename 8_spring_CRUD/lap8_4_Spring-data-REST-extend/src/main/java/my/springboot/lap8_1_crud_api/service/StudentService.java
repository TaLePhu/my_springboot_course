package my.springboot.lap8_1_crud_api.service;

import my.springboot.lap8_1_crud_api.entities.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAllStudentsNotFirstName(String name);
}
