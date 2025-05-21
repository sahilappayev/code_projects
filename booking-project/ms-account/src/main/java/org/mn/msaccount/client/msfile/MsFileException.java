package org.mn.msaccount.client.msfile;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;

public class MsFileException extends RuntimeException {

    private HttpStatus status;
    private List<String> errors;
    private String path;
    private LocalDateTime timestamp;

}