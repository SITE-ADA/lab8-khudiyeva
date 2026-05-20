package az.edu.ada.wm2.courseservice.mapper;

import az.edu.ada.wm2.courseservice.model.dto.CourseRequestDto;
import az.edu.ada.wm2.courseservice.model.dto.CourseResponseDto;
import az.edu.ada.wm2.courseservice.model.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course toEntity(CourseRequestDto dto) {
        return Course.builder()
                .title(dto.getTitle())
                .code(dto.getCode())
                .credits(dto.getCredits())
                .prerequisiteCourseId(dto.getPrerequisiteCourseId())
                .build();
    }

    public CourseResponseDto toDto(Course course) {
        return CourseResponseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .code(course.getCode())
                .credits(course.getCredits())
                .prerequisiteCourseId(course.getPrerequisiteCourseId())
                .build();
    }
}