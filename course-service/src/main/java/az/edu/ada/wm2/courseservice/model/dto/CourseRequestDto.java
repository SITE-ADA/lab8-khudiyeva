package az.edu.ada.wm2.courseservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDto {

    @Schema(description = "Kursun adı", example = "Advanced Programming")
    @NotBlank(message = "Course title is required")
    private String title;

    @Schema(description = "Kursun unikal kodu", example = "CS201")
    @NotBlank(message = "Course code is required")
    private String code;

    @Schema(description = "Kursun kredit sayı", example = "6")
    @Positive(message = "Credits must be positive")
    private Integer credits;

    @Schema(
            description = "İlkin tələb olunan kursun ID-si. İlkin tələb yoxdursa null göndərilir.",
            example = "1",
            nullable = true
    )
    private Long prerequisiteCourseId;
}