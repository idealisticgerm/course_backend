package com.example.courses.service;

import com.example.courses.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CourseService {

    String createCourse(Course employee);
    List<Course> readCourses();
    boolean deleteCourse(Long id);

}
