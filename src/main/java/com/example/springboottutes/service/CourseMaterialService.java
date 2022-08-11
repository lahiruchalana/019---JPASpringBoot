package com.example.springboottutes.service;

import com.example.springboottutes.entity.CourseMaterial;
import com.example.springboottutes.repository.CourseMaterialRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseMaterialService {

    private final CourseMaterialRepository courseMaterialRepository;

    public CourseMaterialService(CourseMaterialRepository courseMaterialRepository) {
        this.courseMaterialRepository = courseMaterialRepository;
    }

    public void addNewCourseMaterial(CourseMaterial courseMaterial) {
        courseMaterialRepository.save(courseMaterial);
    }
}
