package org.mn.msproduct.client.msaccount;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResponseDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
}
