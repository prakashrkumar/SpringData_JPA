package prakash.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prakash.entity.Student;
import prakash.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("DONE");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.fetchStudentById(id);
        return ResponseEntity.ok(student);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name) {
        List<Student> students = studentService.fetchStudentsByName(name);
        return ResponseEntity.ok(students);
    }
}
