package org.example.domain;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Person {

    private Integer id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private BigDecimal salary;
    private Date createdAt;

}
