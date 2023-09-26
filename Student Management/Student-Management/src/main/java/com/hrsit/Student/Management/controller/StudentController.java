package com.hrsit.Student.Management.controller;

import com.hrsit.Student.Management.dto.StudentDto;
import com.hrsit.Student.Management.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    //build add student rest api
    @PostMapping
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto){

        StudentDto savedStudent = studentService.addStudent(studentDto);

      return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);

    }

    // build get student rest api
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") Long studentId){
       StudentDto studentDto =  studentService.getStudent(studentId);
       return new ResponseEntity<>(studentDto, HttpStatus.OK);

    }
    //build get all student rest api
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getAllStudents();
//        return new ResponseEntity<>(students, HttpStatus.OK);
        return ResponseEntity.ok(students);
    }

    //build update student rest api
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updatedStudent(@RequestBody StudentDto studentDto,@PathVariable("id") Long id){
       StudentDto updatedStudent = studentService.updateStudent(studentDto, id);
        return ResponseEntity.ok(updatedStudent);
    }

    //build delete student rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
