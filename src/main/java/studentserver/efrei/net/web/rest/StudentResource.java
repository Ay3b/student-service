package studentserver.efrei.net.web.rest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentserver.efrei.net.domain.Student;
import studentserver.efrei.net.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentResource {

    public final StudentService studentService;
    public StudentResource(StudentService studentService) {this.studentService = studentService;}

    @GetMapping("/students")
    public List<Student> getAllStudents() {return studentService.findAll();}

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable String id){
        //  log.debug("REST request to get Student : {}", id);
        Student student = new Student();
        student.setName("Pierre");
        return student;
    }
}