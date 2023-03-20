package org.flexicode.jwtutorialproject.tutors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.flexicode.jwtutorialproject.students.Student;

import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tutor {
    @Id
    @SequenceGenerator(name = "tutor_sequence", sequenceName = "tutor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutor_sequence")
    private Long tutorId;
    @Transient
    private String tutorTitle;
    @Transient
    private String firstName;
    @Transient
    private String lastName;
    @Column(name = "name")
    private String fullName;
    @Column(name = "course")
    private String courseTaken;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name="tutor_student",
            joinColumns={@JoinColumn(name = "tutor_id")},
            inverseJoinColumns={@JoinColumn(name = "id")}
    )
    private Set<Student> students = new HashSet<Student>();

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorTitle() {
        return tutorTitle;
    }

    public void setTutorTitle(String tutorTitle) {
        this.tutorTitle = tutorTitle;
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

    public String getCourseTaken() {
        return courseTaken;
    }

    public void setCourseTaken(String courseTaken) {
        this.courseTaken = courseTaken;
    }

    public Tutor(String tutorTitle, String firstName, String lastName, String courseTaken, Set<Student> students) {
        this.tutorTitle = tutorTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseTaken = courseTaken;
        this.fullName = tutorTitle + " " + firstName + " " + lastName;
        this.students = students;
    }
    public Tutor(){}
    public Set<Student> getStudent() {
        return students;
    }

    public void setStudent(Set<Student> students) {
        this.students = students;
    }
}
