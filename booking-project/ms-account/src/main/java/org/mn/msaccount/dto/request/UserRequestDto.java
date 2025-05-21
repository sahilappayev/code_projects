package org.mn.msaccount.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.mn.msaccount.annotation.Password;
import org.mn.msaccount.annotation.constant.RoleEnum;

@Getter
@Setter
@ToString
public class UserRequestDto {

    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @Password
    @ToString.Exclude
    private String password;

    @NotNull
    private String firstName;
    private String lastName;
    private List<RoleEnum> roles;

}
