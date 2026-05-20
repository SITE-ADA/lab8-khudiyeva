package az.edu.ada.wm2.studentservice.service;

import az.edu.ada.wm2.studentservice.model.dto.StudentRequestDto;
import az.edu.ada.wm2.studentservice.model.dto.StudentResponseDto;

import java.util.List;

public interface StudentService {

    StudentResponseDto createStudent(StudentRequestDto requestDto);

    List<StudentResponseDto> getAllStudents();

    StudentResponseDto getStudentById(Long id);

    StudentResponseDto updateStudent(Long id, StudentRequestDto requestDto);

    void deleteStudent(Long id);
}