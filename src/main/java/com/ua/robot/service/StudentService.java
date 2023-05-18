package com.ua.robot.service;

import com.ua.robot.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    public List<Student> findAll(){
        return List.of(
                new Student("Ivan", 20, "Kyiv"),
                new Student("Viki", 21, "Lviv"),
                new Student("Jane", 19, "Odesa")
        );
    }
}
