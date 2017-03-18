package com.giit.www.college.service;

import com.giit.www.entity.Course;
import org.springframework.ui.Model;

import java.util.List;


public interface CourseBiz {
    public List<Course> findAll();

    public List<String> findAllSpecName();

    public void add(Course course);

    public void delete(String courseTitle);
}
