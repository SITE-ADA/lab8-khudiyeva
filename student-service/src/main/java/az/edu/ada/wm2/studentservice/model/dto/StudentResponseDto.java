package az.edu.ada.wm2.studentservice.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}