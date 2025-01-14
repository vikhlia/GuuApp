package com.example.guu.utils;

import com.example.guu.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UtilsService {

    public List<Student> findStudentsBySurname(List<Student> allStudents, String surname){
        List<Student> listBySurname = new ArrayList<>();
        for(Student student: allStudents){
            if(student.getSurname().equals(surname)) {
                listBySurname.add(student);
            }
        }
        return listBySurname;
    }
}
