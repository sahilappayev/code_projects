package org.mn.booking.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRequestDto {
    private String username;

    @ToString.Exclude
    private String password;
    private String firstName;
    private String lastName;
}
