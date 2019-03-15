package com.example.whiteboardsp19likithponnanna.services;


import com.example.whiteboardsp19likithponnanna.model.*;

import com.example.whiteboardsp19likithponnanna.repositories.LessonRepository;
import com.example.whiteboardsp19likithponnanna.repositories.TopicRepository;
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
public class TopicService {
  @Autowired
  LessonRepository lessonRepository;
  @Autowired
  TopicRepository topicRepository;


  @GetMapping("/api/lesson/{lid}/topic")
  public List<Topic> findAllTopics(@PathVariable("lid") Long id, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {
      Lesson dbLesson = lessonRepository.findById(id).get();
      return dbLesson.getTopics();
    }
    return new ArrayList <>(Collections.singletonList(new Topic())) ;
  }

  @GetMapping("/api/topic/{tid}")
  public Topic findTopicById(@PathVariable("tid") Long id, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {

      return topicRepository.findById(id).get();
    }
    return new Topic();
  }


  @PostMapping("/api/lesson/{lid}/topic")
  public List<Topic> createTopic(@PathVariable("lid") Long id,
                             @RequestBody Topic topic, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {
      if(topic.getTitle().equals("")){
        topic.setTitle("New Topic");
      }
      topic.setId(new Date().getTime());
      Lesson dbLesson = lessonRepository.findById(id).get();
      topic.setLesson(dbLesson);
      topicRepository.save(topic);

      return dbLesson.getTopics();
    }


    return new ArrayList <>(Arrays.asList(new Topic()));

  }


  @DeleteMapping("/api/topic/{tid}")
  public List<Topic> deleteTopic(@PathVariable("tid") Long id, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {


      Topic dbTopic = topicRepository.findById(id).get();


      topicRepository.deleteById(id);

      Lesson dbLesson = lessonRepository.findById(dbTopic.getLessonId()).get();

      List<Topic> tempTopicList = dbLesson.getTopics();

      return tempTopicList;
    }

    return new ArrayList <>(Collections.singletonList(new Topic())) ;

  }

  @PutMapping("/api/topic/{tid}")
  public List<Topic> updateTopic(@PathVariable("tid") Long id, @RequestBody Topic topic, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");

    if (loggedUser != null) {
      Topic dbTopic = topicRepository.findById(id).get();
      dbTopic.setTitle(topic.getTitle());

      topicRepository.save(dbTopic);

      Lesson dbLesson = lessonRepository.findById(dbTopic.getLesson().getId()).get();
      return dbLesson.getTopics();


    }
    return new ArrayList <>(Arrays.asList(new Topic()));
  }








}
