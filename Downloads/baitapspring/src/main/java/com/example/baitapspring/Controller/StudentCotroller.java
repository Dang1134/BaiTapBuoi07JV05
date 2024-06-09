package com.example.baitapspring.Controller;

import com.example.baitapspring.entity.StudentEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentCotroller {
    private List<StudentEntity> studentEntityList = new ArrayList<StudentEntity>();

    @PostMapping("/addstudent")
    public ResponseEntity<?> addStudent(@RequestParam String name, @RequestParam int age) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(name);
        studentEntity.setAge(age);
        studentEntityList.add(studentEntity);
        return new ResponseEntity<>(studentEntity, HttpStatus.OK);
    }
    @PostMapping("/{name}/{age}")
    public ResponseEntity<?> addStudentPath (@PathVariable String name , @PathVariable int age){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(name);
        studentEntity.setAge(age);
        studentEntityList.add(studentEntity);
        return new ResponseEntity<>(studentEntity, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> addStudentBody ( @RequestBody StudentEntity studentEntity){
        studentEntityList.add(studentEntity);
        return new ResponseEntity<>( studentEntity.getName() + studentEntity.getAge() , HttpStatus.OK);
    }

}
