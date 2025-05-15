package my.springboot.lap11_springmvc.service;


import my.springboot.lap11_springmvc.entities.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student getStudentById(int id);

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void deleteStudentById(int id);
}
