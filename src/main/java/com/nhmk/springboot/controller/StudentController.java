package com.nhmk.springboot.controller;

import com.nhmk.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
//        return new ResponseEntity<>(new Student(1, "Khôi", "Nguyễn"), HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header", "test")
                .body(new Student(1, "Khôi", "Nguyễn"));
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Khôi", "Nguyễn"));
        students.add(new Student(2, "Như", "Nguyễn"));
        return ResponseEntity.ok(students);
    }

    //{id} - URI template variable
    @GetMapping("{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable(value = "id") int id,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(id, firstName, lastName);
    }

    @GetMapping("query")
    public Student studentRequestParam(@RequestParam("id") int id,
                                       @RequestParam("first-name") String firstName,
                                       @RequestParam("last-name") String lastName) {
        return new Student(id, firstName, lastName);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return student;
    }

    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int id) {
        return student;
    }

    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        return "Student " + studentId + " deleted successfully";
    }
}
