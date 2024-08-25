package com.example.courses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instance {
    private Long id;
    private Integer year;
    private Integer semester;
    private Long courseId;  // Foreign key reference to Course
}
