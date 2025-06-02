package com.example.lab4.Entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    private String id;
    private String fullname;

    @Builder.Default
    private String photo = "photo.jpg";

    @Builder.Default
    private Boolean gender = true;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Builder.Default
    private Date birthday = new Date();

    @Builder.Default
    private double salary = 12345.6789;

    @Builder.Default
    private Integer level = 0;
}
