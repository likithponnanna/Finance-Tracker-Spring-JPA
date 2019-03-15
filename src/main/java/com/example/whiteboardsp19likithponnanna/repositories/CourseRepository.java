package com.example.whiteboardsp19likithponnanna.repositories;

import com.example.whiteboardsp19likithponnanna.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    //List<Course> findCoursesForAuthorId(Long id);
}
