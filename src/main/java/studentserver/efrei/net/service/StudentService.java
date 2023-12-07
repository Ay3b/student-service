package studentserver.efrei.net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentserver.efrei.net.domain.Student;
import studentserver.efrei.net.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {return studentRepository.findAll();}
}