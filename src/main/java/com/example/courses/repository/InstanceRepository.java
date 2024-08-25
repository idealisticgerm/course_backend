package com.example.courses.repository;

import com.example.courses.entity.InstanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstanceRepository extends JpaRepository<InstanceEntity, Long> {
    List<InstanceEntity > findByCourse_Id(Long courseId);
}
