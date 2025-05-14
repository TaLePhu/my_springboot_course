package my.springboot.lap8_1_crud_api.controller;


import my.springboot.lap8_1_crud_api.entities.Student;
import my.springboot.lap8_1_crud_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        student.setId(0);
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student studentExisting = studentService.getStudentById(id);
        if(studentExisting != null) {
            studentExisting.setFirstName(student.getFirstName());
            studentExisting.setLastName(student.getLastName());
            studentExisting.setEmail(student.getEmail());
            studentService.updateStudent(studentExisting);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);

        if(student !=null) {
            studentService.deleteStudentById(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }

    }
}
