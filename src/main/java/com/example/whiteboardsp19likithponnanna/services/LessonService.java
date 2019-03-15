package com.example.whiteboardsp19likithponnanna.services;

import com.example.whiteboardsp19likithponnanna.model.*;

import com.example.whiteboardsp19likithponnanna.repositories.CourseRepository;
import com.example.whiteboardsp19likithponnanna.repositories.LessonRepository;
import com.example.whiteboardsp19likithponnanna.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*", allowCredentials= "true", allowedHeaders ="*")
public class LessonService {
  @Autowired
  LessonRepository lessonRepository;

  @Autowired
  ModuleRepository moduleRepository;

  //private CourseService courseService = new CourseService();

  @GetMapping("/api/module/{mid}/lesson")
  public List<Lesson> findAllLessons(@PathVariable("mid") Long id, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {
      Module dbModule = moduleRepository.findById(id).get();
      return dbModule.getLessons();
    }
    return new ArrayList <>(Collections.singletonList(new Lesson())) ;
  }

  @PostMapping("/api/module/{mid}/lesson")
  public List<Lesson> createLesson(@PathVariable("mid") Long id,
                             @RequestBody Lesson lesson, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {
      if(lesson.getTitle().equals("")){
        lesson.setTitle("New Lesson");
      }
      lesson.setId(new Date().getTime());
      Module dbModule = moduleRepository.findById(id).get();
        lesson.setModule(dbModule);
       lessonRepository.save(lesson);

       return dbModule.getLessons();
    }

    return new ArrayList <>(Arrays.asList(new Lesson()));

  }


  @GetMapping("/api/lesson/{lid}")
  public Lesson findLessonById(@PathVariable("lid") Long id, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {
      return lessonRepository.findById(id).get();
    }
    return new Lesson();
  }

  @DeleteMapping("/api/lesson/{lid}")
  public List<Lesson> deleteLesson(@PathVariable("lid") Long id, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {

      Lesson dbLesson = lessonRepository.findById(id).get();

      lessonRepository.deleteById(id);
      Module dbModule = moduleRepository.findById(dbLesson.getModuleId()).get();
      return dbModule.getLessons();
    }

    return new ArrayList <>(Collections.singletonList(new Lesson())) ;

  }



  @PutMapping("/api/lesson/{lid}")
  public List<Lesson> updateLesson(@PathVariable("lid") Long id, @RequestBody Lesson lesson, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");

    if (loggedUser != null) {
      Lesson dbLesson = lessonRepository.findById(id).get();
      dbLesson.setTitle(lesson.getTitle());


       lessonRepository.save(dbLesson);

      Module dbModule = moduleRepository.findById(dbLesson.getModule().getId()).get();
      return dbModule.getLessons();


    }
    return new ArrayList <>(Collections.singletonList(new Lesson())) ;
  }


}
