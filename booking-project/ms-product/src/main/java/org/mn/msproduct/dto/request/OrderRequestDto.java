package org.mn.msproduct.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderRequestDto {

    private Long userId;
    private String name;
    private String description;
}
