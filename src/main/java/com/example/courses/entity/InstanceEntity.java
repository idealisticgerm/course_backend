package com.example.courses.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "instance")
public class InstanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;
    private Integer semester;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "course_id")
    private CourseEntity course;
}
