package org.mn.msaccount.client.msproduct;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MsProductException extends RuntimeException {

    private HttpStatus status;
    private List<String> errors;
    private String path;
    private LocalDateTime timestamp;

}