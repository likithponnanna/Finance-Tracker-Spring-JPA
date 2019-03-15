package com.example.whiteboardsp19likithponnanna.services;

import com.example.whiteboardsp19likithponnanna.model.*;

import com.example.whiteboardsp19likithponnanna.repositories.CourseRepository;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*", allowCredentials= "true", allowedHeaders ="*")
public class ModuleService {
  @Autowired
  ModuleRepository moduleRepository;
  @Autowired
  CourseRepository courseRepository;

private CourseService courseService = new CourseService();


  @GetMapping("/api/course/{cid}/modules")
  public List<Module> findAllModules(@PathVariable("cid") Long id, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {
      Course dbCourse = courseRepository.findById(id).get();
      return dbCourse.getModules();
    }
    return new ArrayList <>(Collections.singletonList(new Module())) ;

  }

  @GetMapping("/api/modules/{mid}")
  public Module findModuleById(@PathVariable("mid") Long id, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {
      Module dbModule = moduleRepository.findById(id).get();
      return dbModule;
    }
   return new Module();
  }

  @PostMapping("/api/courses/{cid}/modules")
  public List<Module> createModule(@PathVariable("cid") Long id,
                             @RequestBody Module module, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {
      if(module.getTitle().equals("")){
        module.setTitle("New Module");
      }
      module.setId(new Date().getTime());
      Course dbCourse = courseRepository.findById(id).get();
      module.setCourse(dbCourse);

      moduleRepository.save(module);

      return dbCourse.getModules();
    }

    return new ArrayList <>(Collections.singletonList(new Module())) ;

  }

  @DeleteMapping("/api/modules/{mid}")
  public List<Module> deleteModule(@PathVariable("mid") Long id, HttpSession session) {
    User loggedUser = (User) session.getAttribute("currentUser");
    if(loggedUser!=null) {

     Module dbModule =  moduleRepository.findById(id).get();

      moduleRepository.deleteById(id);


      Course dbCourse = courseRepository.findById(dbModule.getCourseId()).get();
      return dbCourse.getModules();
    }

  return new ArrayList <>(Collections.singletonList(new Module())) ;
  }

  @PutMapping("/api/modules/{mid}")
  public List<Module> updateModule(@PathVariable("mid") Long id, @RequestBody Module module, HttpSession session) {

    User loggedUser = (User) session.getAttribute("currentUser");

    if (loggedUser != null) {
      Module dbModule = moduleRepository.findById(id).get();
        dbModule.setTitle(module.getTitle());
        moduleRepository.save(dbModule);
        Course dbCourse = courseRepository.findById(dbModule.getCourse().getId()).get();

      return dbCourse.getModules();



    }
    return new ArrayList <>(Arrays.asList(new Module()));
  }


}
