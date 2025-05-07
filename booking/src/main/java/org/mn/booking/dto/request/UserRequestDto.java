package org.mn.booking.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.mn.booking.annotation.Password;
import org.mn.booking.annotation.constant.RoleEnum;

@Getter
@Setter
@ToString
public class UserRequestDto {

    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

//    @NotBlank
//    @Size(min = 6, max = 50)
    @Password
    @ToString.Exclude
    private String password;

    @NotNull
    private String firstName;
    private String lastName;
    private List<RoleEnum> roles;

//    @Email
//    private String email;
//
//    @Positive
//    @Min(value = 18, message = "{age.message}")
//    private Integer age;
}
