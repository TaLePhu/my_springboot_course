package my.springboot.lap8_1_crud_api.service;

import jakarta.transaction.Transactional;
import my.springboot.lap8_1_crud_api.dao.StudentDao;
import my.springboot.lap8_1_crud_api.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.findById(id);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentDao.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentDao.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        studentDao.deleteById(id);
    }
}
