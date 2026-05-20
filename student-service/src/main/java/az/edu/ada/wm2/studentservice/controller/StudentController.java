package az.edu.ada.wm2.studentservice.controller;

import az.edu.ada.wm2.studentservice.model.dto.StudentRequestDto;
import az.edu.ada.wm2.studentservice.model.dto.StudentResponseDto;
import az.edu.ada.wm2.studentservice.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDto createStudent(@Valid @RequestBody StudentRequestDto requestDto) {
        return studentService.createStudent(requestDto);
    }

    @GetMapping
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDto requestDto
    ) {
        return studentService.updateStudent(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}