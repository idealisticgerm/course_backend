package com.example.courses.controller;


import com.example.courses.model.Course;
import com.example.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {
    // Dependency Injection
    @Autowired
    CourseService courseService;


    @GetMapping("api/courses")
    public List<Course> getAllCourses() {
        return courseService.readCourses();
    }


    @PostMapping("api/courses")
    public String createCourse(@RequestBody Course course) {
//        courses.add(course);
        return courseService.createCourse(course);

    }

    @DeleteMapping("api/courses/{id}")
    public String deleteCourse(@PathVariable Long id) {
        if (courseService.deleteCourse(id))
            return "Delete Successfully";
        return "Not Found";
    }


}