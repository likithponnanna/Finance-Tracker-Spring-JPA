package com.example.whiteboardsp19likithponnanna.services;

import com.example.whiteboardsp19likithponnanna.model.Course;
import com.example.whiteboardsp19likithponnanna.model.Lesson;
import com.example.whiteboardsp19likithponnanna.model.Module;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*", allowCredentials= "true", allowedHeaders ="*")
public class LessonService {

  private CourseService courseService = new CourseService();

  @GetMapping("/api/module/{mid}/lesson")
  public List<Lesson> findAllLessons(@PathVariable("mid") Long id, HttpSession session) {
    List<Course> courses = courseService.findAllCourses(session);
    for (Course course: courses) {
      List<Module> modules = course.getModules();
      for (Module module: modules){
        if(module.getId().equals(id)){
          return module.getLessons();
        }
      }

    }
    return new ArrayList <>(Arrays.asList(new Lesson()));
  }

  @PostMapping("/api/module/{mid}/lesson")
  public Lesson createLesson(@PathVariable("mid") Long id,
                             @RequestBody Lesson lesson, HttpSession session) {
    List<Course> courses = courseService.findAllCourses(session);

    for (Course course: courses){
      for (Module module: course.getModules() ) {
       if( module.getId().equals(id)){
         List<Lesson> lessons = module.getLessons();

         lesson.setId(new Date().getTime());
         lesson.setTopics(new ArrayList <>());
         lessons.add(lesson);
         return  lesson;
       }


      }

    }

    return null;

  }


  @GetMapping("/api/lesson/{lid}")
  public Lesson findLessonById(@PathVariable("lid") Long id, HttpSession session) {
    List<Course> courses =courseService.findAllCourses(session);


    if(courses!=null){
      for(Course course:courses){
        for (Module module:course.getModules()){
          for (Lesson lesson: module.getLessons()) {
            if(lesson.getId().equals(id)){
              return lesson;
            }
          }

        }
      }
    }

    return null;
  }

  @DeleteMapping("/api/lesson/{lid}")
  public List<Lesson> deleteLesson(@PathVariable("lid") Long id, HttpSession session) {
    List <Course> courses = courseService.findAllCourses(session);
    if (courses != null) {
      for (Course course : courses) {
        for (Module module : course.getModules()) {
          List <Lesson> lessons = module.getLessons();

          for (int i = 0; i < lessons.size(); i++) {
          if(lessons.get(i).getId().equals(id)){
            lessons.remove(i);
            return lessons;

          }

          }

        }
      }

    }
    return new ArrayList <>(Arrays.asList(new Lesson()));

  }



  @PutMapping("/api/lesson/{lid}")
  public List<Lesson> updateLesson(@PathVariable("lid") Long id, @RequestBody Lesson lesson, HttpSession session) {
    List<Course> courses = courseService.findAllCourses(session);

    for (Course course: courses) {
      for (Module module: course.getModules()) {
        List<Lesson> lessons = module.getLessons();
        for (int i = 0; i <lessons.size() ; i++) {
          if(lessons.get(i).getId().equals(id)){
            lesson.setId(lessons.get(i).getId());
            lesson.setTopics(lessons.get(i).getTopics());
            lessons.set(i,lesson);
            return lessons;
          }

        }

      }

    }
    return new ArrayList <>(Arrays.asList(new Lesson()));
  }








}
