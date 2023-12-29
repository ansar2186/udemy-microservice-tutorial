package com.javaguides.departmentservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl-departments")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

}
