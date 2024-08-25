package com.example.courses.service;

import com.example.courses.model.Instance;

import java.util.List;

public interface InstanceService {
    String createInstance(Instance instance);
     List<Instance> readAllInstances();
    List<Instance> readInstances(Long courseId);
    boolean deleteInstance(Long id);
}
