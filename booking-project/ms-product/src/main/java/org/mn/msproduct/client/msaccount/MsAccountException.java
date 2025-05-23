package org.mn.msproduct.client.msaccount;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MsAccountException extends RuntimeException {

    private HttpStatus status;
    private List<String> errors;
    private String path;
    private LocalDateTime timestamp;

}