package org.flexicode.jwtutorialproject.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @PostMapping(path = "api/students/save+all")
    public void saveStudents(@RequestBody Student... students){
        studentRepository.saveAll(Arrays.asList(students));
    }
}
