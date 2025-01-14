package com.example.guu.utils;

import com.example.guu.entity.Student;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class UtilsService {
    public int getStudentCount(List<Student> studentsList) {
        int count = 0;
        for (Student student : studentsList) {
                count ++;
        }
        return count;
    }

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
