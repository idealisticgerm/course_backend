package com.example.courses.service;
import com.example.courses.entity.CourseEntity;
import com.example.courses.model.Course;
import com.example.courses.repository.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImplementation implements CourseService {

    @Autowired
    private CourseRepository courseRepository;



    @Override
    public String createCourse(Course course) {
        CourseEntity courseEntity = new CourseEntity();
        BeanUtils.copyProperties(course,courseEntity);
        courseRepository.save(courseEntity);
//         courses.add(course);
        return "Saved Successfully !!";
    }

    @Override
    public List<Course> readCourses() {
        List<CourseEntity> coursesList = courseRepository.findAll();
        List<Course> courses = new ArrayList<>();
        for(CourseEntity courseEntity:coursesList){
            Course cou = new Course();
            cou.setId(courseEntity.getId());
            cou.setTitle(courseEntity.getTitle());
            cou.setCourse_code(courseEntity.getCourse_code());
            cou.setDescription(courseEntity.getDescription());
            courses.add(cou);
        }

        return courses;
    }

    @Override
    public boolean deleteCourse(Long id) {
//        return courses.removeIf(course -> course.getId().equals(id));
        CourseEntity cou = courseRepository.findById(id).get();
        courseRepository.delete(cou);
        return true;
    }


}
