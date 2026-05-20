package az.edu.ada.wm2.studentservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {

    @Schema(example = "Ali")
    @NotBlank(message = "First name is required")
    private String firstName;

    @Schema(example = "Mammadov")
    @NotBlank(message = "Last name is required")
    private String lastName;

    @Schema(example = "ali.mammadov@ada.edu.az")
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
}