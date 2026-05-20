package az.edu.ada.wm2.studentservice.controller;

import az.edu.ada.wm2.studentservice.model.dto.StudentRequestDto;
import az.edu.ada.wm2.studentservice.model.dto.StudentResponseDto;
import az.edu.ada.wm2.studentservice.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Tag(name = "Tələbələr", description = "Tələbələrin yaradılması, yenilənməsi, silinməsi və axtarışı")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Yeni tələbə yarat", description = "Sistemdə yeni tələbə yaradır.")
    public StudentResponseDto createStudent(@Valid @RequestBody StudentRequestDto requestDto) {
        return studentService.createStudent(requestDto);
    }

    @GetMapping
    @Operation(summary = "Bütün tələbələri göstər", description = "Sistemdə olan bütün tələbələrin siyahısını qaytarır.")
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Tələbəni ID ilə göstər", description = "Verilmiş ID-yə uyğun tələbə məlumatlarını qaytarır.")
    public StudentResponseDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Tələbəni ada görə axtar", description = "Ad və ya soyad daxilində axtarış aparır.")
    public List<StudentResponseDto> searchStudentsByName(@RequestParam String name) {
        return studentService.searchStudentsByName(name);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Tələbə məlumatlarını yenilə", description = "Verilmiş ID-yə uyğun tələbənin məlumatlarını yeniləyir.")
    public StudentResponseDto updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDto requestDto
    ) {
        return studentService.updateStudent(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Tələbəni sil", description = "Verilmiş ID-yə uyğun tələbəni sistemdən silir.")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}