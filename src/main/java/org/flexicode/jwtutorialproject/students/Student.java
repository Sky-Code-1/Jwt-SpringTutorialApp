package org.flexicode.jwtutorialproject.students;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.flexicode.jwtutorialproject.tutors.Tutor;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long studentId;
    private String firstName;
    private String lastName;
    private String courseOfStudy;
    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private Set<Tutor> tutors = new HashSet<Tutor>();

    public Student(String firstName, String lastName, String courseOfStudy, Set<Tutor> tutors) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseOfStudy = courseOfStudy;
        this.tutors = tutors;
    }

    public Student(){}
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourseOfStudy() {
        return courseOfStudy;
    }

    public void setCourseOfStudy(String courseOfStudy) {
        this.courseOfStudy = courseOfStudy;
    }

    public Set<Tutor> getTutors() {
        return tutors;
    }

    public void setTutors(Set<Tutor> tutors) {
        this.tutors = tutors;
    }
}
