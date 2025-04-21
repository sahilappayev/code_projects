package com.example.spring_jdbc.spring_jdbc.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private BigDecimal salary;
    private Date createdAt;

}
