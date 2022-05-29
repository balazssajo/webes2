package com.javatpoint.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class StudentRequest {
    private String street;
    private String name;
    private String age;
    private String email;
}
