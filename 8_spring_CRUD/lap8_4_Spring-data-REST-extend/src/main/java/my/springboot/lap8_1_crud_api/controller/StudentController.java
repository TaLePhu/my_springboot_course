package my.springboot.lap8_1_crud_api.controller;

import my.springboot.lap8_1_crud_api.entities.Student;
import my.springboot.lap8_1_crud_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/not-first-name/{name}")
    public List<Student> getAllStudentsNotFirstName(@PathVariable String name){
        return studentService.findAllStudentsNotFirstName(name);
    }


}
