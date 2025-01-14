package com.example.guu.controller;

import com.example.guu.entity.Id;
import com.example.guu.entity.Student;
import com.example.guu.service.StudentServiceImpl;
import com.example.guu.utils.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    UtilsService utilsService;

    @GetMapping("/main")
    public String mainPage(Model model){

        int countStudents = utilsService.getStudentCount(studentService.getAllStudents());
        model.addAttribute("countStudents", countStudents);

        return "main-page";
    }

    @PostMapping("/main")
    public String submit(@ModelAttribute Student student, Model model){
        Student newStudent = new Student();
        newStudent.setId(student.getId());
        newStudent.setName(student.getName());
        newStudent.setSurname(student.getSurname());
        newStudent.setCourse(student.getCourse());
        studentService.saveStudent(newStudent);
        return "redirect:/main";
    }

    @GetMapping("/findStudent")
    public String findPage(){

        return "find-page";
    }

    @PostMapping("/findStudent")
    public String findStudent(@ModelAttribute Student student, Model model){

        List<Student> foundStudents = utilsService.findStudentsBySurname(studentService.getAllStudents(), student.getSurname());
        model.addAttribute("foundStudents", foundStudents);
        return "foundStudents-page";
    }

    @GetMapping("/deleteStudent")
    public String deletePage(){

        return "delete-page";
    }

    @PostMapping("/deleteStudent")
    public String deleteStudent(@ModelAttribute Id id, Model model){

        studentService.deleteStudent(id.getId());
        return "redirect:/main";
    }

    @GetMapping("/allStudents")
    public String allStudents(Model model){
        List<Student> allStudents = studentService.getAllStudents();
        model.addAttribute("allStudents", allStudents);

        return "allStudents-page";
    }

}
