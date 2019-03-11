package com.example.whiteboardsp19likithponnanna.services;

import com.example.whiteboardsp19likithponnanna.model.Course;
import com.example.whiteboardsp19likithponnanna.model.Lesson;
import com.example.whiteboardsp19likithponnanna.model.Module;
import com.example.whiteboardsp19likithponnanna.model.Topic;
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
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*", allowCredentials= "true", allowedHeaders ="*")
public class ModuleService {
private CourseService courseService = new CourseService();


  @GetMapping("/api/course/{cid}/modules")
  public List<Module> findAllModules(@PathVariable("cid") Long id, HttpSession session) {
    Course course = courseService.findCourseById(id,session);
    if(course != null)
    {
      return course.getModules();
    }
    return new ArrayList <>(Arrays.asList(new Module()));
  }

  @GetMapping("/api/modules/{mid}")
  public Module findModuleById(@PathVariable("mid") Long id, HttpSession session) {
    List<Course> courses =courseService.findAllCourses(session);
    if(courses!=null){
      for(Course course:courses){
        List<Module> modules =  course.getModules();
        for (Module module:modules){
          if(module.getId().equals(id)){
            return module;
          }
        }
      }
    }

    return new Module();
  }

  @PostMapping("/api/courses/{cid}/modules")
  public List<Module> createModule(@PathVariable("cid") Long id,
                             @RequestBody Module module, HttpSession session) {
    Course course = courseService.findCourseById(id,session);

    if(course!=null){
      List<Module> modules =  course.getModules();
      module.setId(new Date().getTime());
      module.setLessons(new ArrayList <>());
      modules.add(module);
      course.setModules(modules);
      return modules;
    }

    /*modules.add(module);
    return module;*/
    return new ArrayList <>(Arrays.asList(new Module()));

  }

  @DeleteMapping("/api/modules/{mid}")
  public List<Module> deleteModule(@PathVariable("mid") Long id, HttpSession session) {
    List<Course> courses = courseService.findAllCourses(session);
    if(courses!=null) {
      for (Course course:courses) {
        List<Module> modules = course.getModules();
        for (int i=0;i<modules.size();i++){
          if(modules.get(i).getId().equals(id)){
            modules.remove(i);
            return modules;
          }
        }


      }
    }

  return new ArrayList <>(Collections.singletonList(new Module())) ;
  }

  @PutMapping("/api/modules/{mid}")
  public Module updateModule(@PathVariable("mid") Long id, @RequestBody Module module, HttpSession session) {
    List<Course> courses = courseService.findAllCourses(session);

    for (Course course: courses) {
      List<Module> modules = course.getModules();

      for (int i = 0; i < modules.size(); i++) {
        if (modules.get(i).getId().equals(id)){
          module.setId(modules.get(i).getId());
          module.setLessons(modules.get(i).getLessons());

          modules.set(i, module);
          return modules.get(i);
        }

      }

    }
    return new Module();
  }


}
