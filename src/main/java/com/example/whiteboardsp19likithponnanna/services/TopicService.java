package com.example.whiteboardsp19likithponnanna.services;


import com.example.whiteboardsp19likithponnanna.model.Course;
import com.example.whiteboardsp19likithponnanna.model.Lesson;
import com.example.whiteboardsp19likithponnanna.model.Module;
import com.example.whiteboardsp19likithponnanna.model.Topic;

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
public class TopicService {


  private CourseService courseService = new CourseService();

  @GetMapping("/api/lesson/{lid}/topic")
  public List<Topic> findAllTopics(@PathVariable("lid") Long id, HttpSession session) {
    List<Course> courses = courseService.findAllCourses(session);
    for (Course course: courses) {
      for (Module module: course.getModules()){
        for(Lesson lesson: module.getLessons()){
          if(lesson.getId().equals(id)){
            return lesson.getTopics();
          }
        }

      }

    }
    return new ArrayList <>(Arrays.asList(new Topic()));
  }

  @GetMapping(" /api/topic/{tid}")
  public Topic findTopicById(@PathVariable("tid") Long id, HttpSession session) {
    List<Course> courses =courseService.findAllCourses(session);

    if(courses!=null){
      for(Course course:courses){
        for (Module module:course.getModules()){
          for (Lesson lesson: module.getLessons()) {
            for(Topic topic: lesson.getTopics()) {
              if (topic.getId().equals(id)) {
                return topic;
              }
            }
          }

        }
      }
    }

    return new Topic();
  }


  @PostMapping("/api/lesson/{lid}/topic")
  public List<Topic> createTopic(@PathVariable("lid") Long id,
                             @RequestBody Topic topic, HttpSession session) {
    List<Course> courses = courseService.findAllCourses(session);

    for (Course course: courses){
      for (Module module: course.getModules() ) {
        for (Lesson lesson: module.getLessons()) {
          if(lesson.getId().equals(id)) {
            List<Topic> topics = lesson.getTopics();
            topic.setId(new Date().getTime());
            topic.setWidgets(new ArrayList <>());
            topics.add(topic);
            return topics;
          }

        }


      }

    }

    return new ArrayList <>(Arrays.asList(new Topic()));

  }


  @DeleteMapping("/api/topic/{tid}")
  public List<Topic> deleteTopic(@PathVariable("tid") Long id, HttpSession session) {
    List <Course> courses = courseService.findAllCourses(session);
    if (courses != null) {
      for (Course course : courses) {
        for (Module module : course.getModules()) {
          for(Lesson lesson: module.getLessons()) {
            List <Topic> topics = lesson.getTopics();

            for (int i = 0; i < topics.size(); i++) {
              if (topics.get(i).getId().equals(id)) {
                topics.remove(i);
                return topics;

              }

            }
          }

        }
      }

    }
    return new ArrayList <>(Arrays.asList(new Topic()));

  }

  @PutMapping("/api/topic/{tid}")
  public List<Topic> updateTopic(@PathVariable("tid") Long id, @RequestBody Topic topic, HttpSession session) {
    List<Course> courses = courseService.findAllCourses(session);

    for (Course course: courses) {
      for (Module module: course.getModules()) {
        for(Lesson lesson: module.getLessons()) {
          List <Topic> topics = lesson.getTopics();
          for (int i = 0; i < topics.size(); i++) {
            if (topics.get(i).getId().equals(id)) {
              topic.setId(topics.get(i).getId());
              topic.setWidgets(topics.get(i).getWidgets());
              topics.set(i, topic);
              return topics;
            }

          }
        }

      }

    }
    return new ArrayList <>(Arrays.asList(new Topic()));
  }








}
