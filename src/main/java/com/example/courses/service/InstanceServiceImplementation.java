package com.example.courses.service;

import com.example.courses.entity.CourseEntity;
import com.example.courses.entity.InstanceEntity;
import com.example.courses.model.Instance;
import com.example.courses.repository.CourseRepository;
import com.example.courses.repository.InstanceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstanceServiceImplementation implements InstanceService {

    @Autowired
    private InstanceRepository instanceRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String createInstance(Instance instance) {
        InstanceEntity instanceEntity = new InstanceEntity();
        BeanUtils.copyProperties(instance, instanceEntity);
        CourseEntity courseEntity = courseRepository.findById(instance.getCourseId()).orElse(null);
        if (courseEntity == null) {
            return "Course not found";
        }
        instanceEntity.setCourse(courseEntity);
        instanceRepository.save(instanceEntity);
        return "Instance saved successfully!";
    }

    @Override
    public List<Instance> readAllInstances() {
        List<InstanceEntity> instancesList = instanceRepository.findAll();        List<Instance> instances = new ArrayList<>();
        for (InstanceEntity instanceEntity : instancesList) {
            Instance instance = new Instance();
            instance.setId(instanceEntity.getId());
            instance.setYear(instanceEntity.getYear());
            instance.setSemester(instanceEntity.getSemester());
            instance.setCourseId(instanceEntity.getCourse().getId());
            instances.add(instance);
        }
        return instances;
    }

    @Override
    public List<Instance> readInstances(Long courseId) {
        List<InstanceEntity> instancesList = instanceRepository.findByCourse_Id(courseId);
        List<Instance> instances = new ArrayList<>();
        for (InstanceEntity instanceEntity : instancesList) {
            Instance instance = new Instance();
            instance.setId(instanceEntity.getId());
            instance.setYear(instanceEntity.getYear());
            instance.setSemester(instanceEntity.getSemester());
            instance.setCourseId(instanceEntity.getCourse().getId());
            instances.add(instance);
        }
        return instances;
    }

    @Override
    public boolean deleteInstance(Long id) {
        InstanceEntity instanceEntity = instanceRepository.findById(id).orElse(null);
        if (instanceEntity != null) {
            instanceRepository.delete(instanceEntity);
            return true;
        }
        return false;
    }
}
