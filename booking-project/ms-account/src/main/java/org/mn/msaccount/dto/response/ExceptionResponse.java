package org.mn.msaccount.dto.response;


import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ExceptionResponse {

    private HttpStatus status;
    private List<String> errors;
    private String path;
    private LocalDateTime timestamp;

}
