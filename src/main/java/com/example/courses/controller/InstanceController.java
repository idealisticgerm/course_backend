package com.example.courses.controller;

import com.example.courses.model.Instance;
import com.example.courses.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instances")
public class InstanceController {

    @Autowired
    private InstanceService instanceService;

    @PostMapping
    public String createInstance(@RequestBody Instance instance) {
        return instanceService.createInstance(instance);
    }

    @GetMapping
    public List<Instance> getAllInstances() {
        return instanceService.readAllInstances();
    }

    @GetMapping("/{courseId}")
    public List<Instance> getInstancesByCourseId(@PathVariable Long courseId) {
        return instanceService.readInstances(courseId);
    }

    @DeleteMapping("/{id}")
    public String deleteInstance(@PathVariable Long id) {
        if (instanceService.deleteInstance(id)) {
            return "Instance deleted successfully!";
        }
        return "Instance not found!";
    }
}
