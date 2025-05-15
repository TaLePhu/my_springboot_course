package my.springboot.lap11_springmvc.controller;


import my.springboot.lap11_springmvc.entities.Student;
import my.springboot.lap11_springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

//    @GetMapping
//    public List<Student> getAllStudents() {
//        return studentService.getAllStudents();
//    }
//
//    @PostMapping
//    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
//        student.setId(0);
//        studentService.addStudent(student);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
//        Student student = studentService.getStudentById(id);
//        if (student == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(student);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
//        Student studentExisting = studentService.getStudentById(id);
//        if(studentExisting != null) {
//            studentExisting.setFirstName(student.getFirstName());
//            studentExisting.setLastName(student.getLastName());
//            studentExisting.setEmail(student.getEmail());
//            studentService.updateStudent(studentExisting);
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudentById(@PathVariable int id) {
//        Student student = studentService.getStudentById(id);
//
//        if(student !=null) {
//            studentService.deleteStudentById(id);
//            return ResponseEntity.ok().build();
//        }else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }
}
