package my.springboot.lap8_1_crud_api.service;

import my.springboot.lap8_1_crud_api.entities.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student getStudentById(int id);

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void deleteStudentById(int id);
}
