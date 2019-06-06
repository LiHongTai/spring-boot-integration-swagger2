package com.github.roger.mock;

import com.github.roger.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMockData {


    public static List<Student> list(){
        List<Student> studentList = new ArrayList<>();

        Student student = new Student(1L,"Roger");
        studentList.add(student);

        student = new Student(2L,"Mary");
        studentList.add(student);

        student = new Student(3L,"Jim");
        studentList.add(student);

        return studentList;
    }
}
