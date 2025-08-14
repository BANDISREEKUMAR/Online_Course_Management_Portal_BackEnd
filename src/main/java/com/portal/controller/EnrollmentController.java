package com.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.Enrollment;
import com.portal.model.User;
import com.portal.repository.EnrollmentRepository;
import com.portal.repository.UserRepository;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/my-courses")
    public ResponseEntity<List<Enrollment>> getMyCourses(Authentication auth) {
        String email = auth.getName();
        User user = userRepository.findByEmail(email)
                                  .orElseThrow(() -> new RuntimeException("User not found"));
        List<Enrollment> enrollments = enrollmentRepository.findByUserOrderByEnrolledAtDesc(user);
        return ResponseEntity.ok(enrollments);
    }
}
