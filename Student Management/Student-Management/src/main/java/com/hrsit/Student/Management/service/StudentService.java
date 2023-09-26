package com.hrsit.Student.Management.service;

import com.hrsit.Student.Management.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto addStudent(StudentDto studentdto);

    StudentDto getStudent(Long id);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(StudentDto studentDto, Long id);

    void deleteStudent(Long id);

}
