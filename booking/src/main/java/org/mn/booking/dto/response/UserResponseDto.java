package org.mn.booking.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

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
    private Date createdAt;
    private Date updatedAt;
}
