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

    @GetMapping("/form")
    public String getStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "students-form";
    }

    @PostMapping("/save")
    public String saveOrUpdateStudent(@ModelAttribute("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("/update")
    public String updateStudent(@RequestParam("id") Integer id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "students-form";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/students/list";
    }

}
