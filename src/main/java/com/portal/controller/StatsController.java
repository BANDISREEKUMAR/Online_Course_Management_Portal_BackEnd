package com.portal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.repository.CourseRepository;
import com.portal.repository.EnrollmentRepository;
import com.portal.repository.UserRepository;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin(origins = "*")
public class StatsController {
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    @GetMapping
    public ResponseEntity<Map<String, Object>> getStats() {
        Map<String, Object> stats = new HashMap<>();
        
        Long totalCourses = courseRepository.countActiveCourses();
        stats.put("totalCourses", totalCourses);
        

        Long totalStudents = userRepository.countStudents();
        Long totalAdmins = userRepository.countAdmins();
        stats.put("totalStudents", totalStudents);
        stats.put("totalInstructors", totalAdmins);
        

        Long totalEnrollments = enrollmentRepository.countCompletedEnrollments();
        stats.put("totalEnrollments", totalEnrollments);
        
        return ResponseEntity.ok(stats);
    }
} 