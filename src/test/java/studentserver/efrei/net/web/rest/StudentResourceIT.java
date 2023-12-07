package studentserver.efrei.net.web.rest;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import studentserver.efrei.net.domain.Student;
import studentserver.efrei.net.repository.StudentRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@TestPropertySource(
        locations= "classpath:application-test.properties"
)

public class StudentResourceIT {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    void createStudent() throws Exception {
        int databaseSizeBeforeCreate = studentRepository.findAll().size();
        assertThat(databaseSizeBeforeCreate).isEqualTo(0);

        Student student = new Student();
        //Student.setId(6);
        student.setName("Pierre");
        student.setAge(12);
        studentRepository.save(student);

        List<Student> studentList = studentRepository.findAll();
        assertThat(studentList).hasSize(databaseSizeBeforeCreate +1);
    }
}
