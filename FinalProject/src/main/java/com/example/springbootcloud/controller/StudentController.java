package com.example.springbootcloud.controller;

import com.example.springbootcloud.model.dto.StudentDTO;
import com.example.springbootcloud.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

//    @PostMapping("")
//    public ResponseEntity<?> createStudent(@RequestBody StudentDTO req){
//        return ResponseEntity.ok(req);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO req, @PathVariable("id") Long id){
        req.setStudent_id(id);
        StudentDTO result = studentService.updateStudent(req);
        return ResponseEntity.ok(req);
    }

    @GetMapping("")
    public ResponseEntity<?> getStudent(){
        return ResponseEntity.ok(studentService.getListStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id){
        StudentDTO result = studentService.getStudentByID(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "Success";
    }
}