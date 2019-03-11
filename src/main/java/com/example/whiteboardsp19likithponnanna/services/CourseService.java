package com.example.whiteboardsp19likithponnanna.services;

import com.example.whiteboardsp19likithponnanna.model.Course;
import com.example.whiteboardsp19likithponnanna.model.Lesson;
import com.example.whiteboardsp19likithponnanna.model.Module;
import com.example.whiteboardsp19likithponnanna.model.Topic;
import com.example.whiteboardsp19likithponnanna.model.User;
import com.example.whiteboardsp19likithponnanna.model.Widget;

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

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders ="*")
@RestController
public class CourseService {


  private static List<Course> courses;

  public CourseService(){
    User alice = new User((long) 123, "alice", "pass123", "Alice", "Wonderland", "FACULTY", "def@gmail.com", "816225");
    Course CS5400 = new Course((long)123, "CS-4500", alice, new ArrayList <>());
    User bob = new User((long) 234, "bob", "pass245", "Bob", "Marley", "FACULTY", "new@gmail.com", "123141");
    Course CS4500 = new Course((long)234, "CS-4500", bob, new ArrayList <>());
    courses = new ArrayList <>();
    courses.addAll(Arrays.asList(CS5400,CS4500));

  }



  @GetMapping("/api/courses")
  public List<Course> findAllCourses(HttpSession session) {
    List<Course> courses = new ArrayList <>();
    User loggedUser = (User) session.getAttribute("currentUser");

    if(loggedUser !=null){
      for (Course course: CourseService.courses){
        if(course.getUser().getUserId().equals(loggedUser.getUserId())){
          courses.add(course);
        }
      }
    }

    return courses;
  }

  @GetMapping("/api/courses/{cid}")
  public Course findCourseById(@PathVariable("cid") Long id, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {
      for (int i = 0; i < courses.size(); i++) {
        if (courses.get(i).getId().equals(id) && courses.get(i).getUser().getUserId().equals(loggedUser.getUserId())) {

          return courses.get(i);

        }
      }
    }
    return new Course();
  }

  @PostMapping("/api/courses")
  public List<Course> createCourse(@RequestBody Course course, HttpSession session) {
    System.out.println(course.getModules());
    if(session.getAttribute("currentUser")!=null){
      course.setUser((User) session.getAttribute("currentUser"));
      course.setId(new Date().getTime());
      if(course.getTitle().equals("")){
        course.setTitle("New Course");
      }
      course.setModules(new ArrayList <>());
      courses.add(course);

    }
    return courses;

  }

  @DeleteMapping("/api/courses/{cid}")
  public List<Course> deleteCourse(@PathVariable("cid") Long id, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {
      for (int i = 0; i < courses.size(); i++) {
        if (courses.get(i).getId().equals(id)) {
          courses.remove(i);
          return courses;
        }
      }
    }
    return new ArrayList <>(Arrays.asList(new Course()));
  }

  @PutMapping("/api/courses/{cid}")
  public Course updateCourse(@PathVariable("cid") Long id, @RequestBody Course course, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");

    if(loggedUser!=null) {
      for (int i = 0; i < courses.size(); i++) {
        if (courses.get(i).getId().equals(id) && courses.get(i).getUser().getUserId().equals(loggedUser.getUserId())) {
         courses.set(i,course);

          return courses.get(i);
        }
      }
    }
    return new Course();
  }




}
