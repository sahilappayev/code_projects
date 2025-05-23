package org.mn.msaccount.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.mn.msaccount.annotation.constant.RoleEnum;
import org.mn.msaccount.client.msproduct.OrderResponseDto;

@Getter
@Setter
@ToString
public class UserResponseDto {
    private Long id;
    private String username;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @ToString.Exclude
    private String password;
    private String firstName;
    private String lastName;
    private String image;
    private List<RoleEnum> roles;
    private List<OrderResponseDto> orders;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime currentDate;
}
