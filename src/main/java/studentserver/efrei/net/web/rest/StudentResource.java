package studentserver.efrei.net.web.rest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentserver.efrei.net.domain.Student;
import studentserver.efrei.net.service.StudentService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentResource {

    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    // Endpoint pour récupérer tous les étudiants
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    // Endpoint pour récupérer un étudiant par son ID
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
        Optional<Student> student = studentService.findById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint pour créer un nouvel étudiant
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.save(student);
        return ResponseEntity.created(URI.create("/api/students/" + createdStudent.getId())).body(createdStudent);
    }

    // Endpoint pour mettre à jour un étudiant par son ID
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
        Optional<Student> existingStudent = studentService.findById(id);
        if (existingStudent.isPresent()) {
            updatedStudent.setId(id); // Assurez-vous que l'ID est défini pour la mise à jour
            Student savedStudent = studentService.save(updatedStudent);
            return ResponseEntity.ok(savedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour supprimer un étudiant par son ID
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        if (studentService.existsById(id)) {
            studentService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
