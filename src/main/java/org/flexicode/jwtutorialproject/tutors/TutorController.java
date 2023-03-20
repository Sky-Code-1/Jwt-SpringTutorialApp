package org.flexicode.jwtutorialproject.tutors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TutorController {
    private TutorRepository tutorRepository;

    @Autowired
    public TutorController(TutorRepository tutorRepository){
        this.tutorRepository = tutorRepository;
    }
}
