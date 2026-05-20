package az.edu.ada.wm2.studentservice.service.impl;

import az.edu.ada.wm2.studentservice.mapper.StudentMapper;
import az.edu.ada.wm2.studentservice.model.dto.StudentRequestDto;
import az.edu.ada.wm2.studentservice.model.dto.StudentResponseDto;
import az.edu.ada.wm2.studentservice.model.entity.Student;
import az.edu.ada.wm2.studentservice.repository.StudentRepository;
import az.edu.ada.wm2.studentservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponseDto createStudent(StudentRequestDto requestDto) {
        if (studentRepository.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("Student with this email already exists");
        }

        Student student = studentMapper.toEntity(requestDto);
        Student savedStudent = studentRepository.save(student);

        return studentMapper.toDto(savedStudent);
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @Override
    public StudentResponseDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        return studentMapper.toDto(student);
    }

    @Override
    public StudentResponseDto updateStudent(Long id, StudentRequestDto requestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        student.setFirstName(requestDto.getFirstName());
        student.setLastName(requestDto.getLastName());
        student.setEmail(requestDto.getEmail());

        Student updatedStudent = studentRepository.save(student);

        return studentMapper.toDto(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        studentRepository.delete(student);
    }
}