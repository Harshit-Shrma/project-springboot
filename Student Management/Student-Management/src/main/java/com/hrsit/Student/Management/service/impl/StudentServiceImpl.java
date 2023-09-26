package com.hrsit.Student.Management.service.impl;

import com.hrsit.Student.Management.dto.StudentDto;
import com.hrsit.Student.Management.entity.Student;
import com.hrsit.Student.Management.exception.ResourceNotFounException;
import com.hrsit.Student.Management.repository.StudentRepository;
import com.hrsit.Student.Management.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    private ModelMapper modelMapper;

    @Override
    public StudentDto addStudent(StudentDto studentdto) {
            // dto into jpa entity

        Student student = modelMapper.map(studentdto, Student.class);

        //jpa entity
        Student savedStudent = studentRepository.save(student);

        //convert saved jpa entity into dto object


        StudentDto savedStudentDto = modelMapper.map(savedStudent, StudentDto.class);
        return savedStudentDto;
    }

    @Override
    public StudentDto getStudent(Long id) {

        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFounException("Student not found with id" + id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map((student)-> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, Long id) {

        Student student = studentRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFounException("Student not found with id" + id));
        student.setName(studentDto.getName());
        student.setPhone(studentDto.getPhone());
        student.setMarks(studentDto.getMarks());
        Student updatedStudent = studentRepository.save(student);
        return modelMapper.map(updatedStudent, StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = studentRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFounException("Student not found with id" + id));
        studentRepository.deleteById(id);
    }
}
