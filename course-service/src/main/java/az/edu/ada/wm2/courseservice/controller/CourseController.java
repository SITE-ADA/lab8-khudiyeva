package az.edu.ada.wm2.courseservice.controller;

import az.edu.ada.wm2.courseservice.model.dto.CourseRequestDto;
import az.edu.ada.wm2.courseservice.model.dto.CourseResponseDto;
import az.edu.ada.wm2.courseservice.model.dto.CourseStudentsResponseDto;
import az.edu.ada.wm2.courseservice.model.dto.EnrollmentResponseDto;
import az.edu.ada.wm2.courseservice.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
@Tag(name = "Kurslar", description = "Kursların idarə edilməsi, tələbə qeydiyyatı və axtarış endpoint-ləri")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    @Operation(summary = "Yeni kurs yarat", description = "Sistemdə yeni kurs yaradır. Kurs üçün ilkin tələb olunan kurs ID-si də göndərilə bilər.")
    public ResponseEntity<CourseResponseDto> createCourse(@Valid @RequestBody CourseRequestDto requestDto) {
        return new ResponseEntity<>(courseService.createCourse(requestDto), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Bütün kursları göstər", description = "Sistemdə olan bütün kursların siyahısını qaytarır.")
    public ResponseEntity<List<CourseResponseDto>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Kursu ID ilə göstər", description = "Verilmiş ID-yə uyğun kurs məlumatlarını qaytarır.")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Kursu yenilə", description = "Kursun adını, kodunu, kredit sayını və ilkin tələb olunan kurs ID-sini yeniləyir.")
    public ResponseEntity<CourseResponseDto> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequestDto requestDto) {
        return ResponseEntity.ok(courseService.updateCourse(id, requestDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Kursu sil", description = "Verilmiş ID-yə uyğun kursu sistemdən silir.")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{courseId}/students/{studentId}")
    @Operation(
            summary = "Tələbəni kursa qeydiyyatdan keçir",
            description = "Tələbəni kursa yazır, qeydiyyat tarixini saxlayır və kursun ilkin tələbini yoxlayır."
    )
    public ResponseEntity<EnrollmentResponseDto> enrollStudent(
            @PathVariable Long courseId,
            @PathVariable Long studentId) {
        return new ResponseEntity<>(courseService.enrollStudent(courseId, studentId), HttpStatus.CREATED);
    }

    @GetMapping("/{courseId}/students")
    @Operation(
            summary = "Kursa yazılmış tələbələri göstər",
            description = "Verilmiş kursa qeydiyyatdan keçmiş tələbələrin məlumatlarını qaytarır."
    )
    public ResponseEntity<CourseStudentsResponseDto> getCourseStudents(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.getCourseStudents(courseId));
    }

    @GetMapping("/by-student-name")
    @Operation(
            summary = "Tələbə adına görə kursları göstər",
            description = "Tələbənin adına və ya soyadına görə həmin tələbəyə bağlı kursları qaytarır."
    )
    public ResponseEntity<List<CourseResponseDto>> getCoursesByStudentName(@RequestParam String name) {
        return ResponseEntity.ok(courseService.getCoursesByStudentName(name));
    }
}