package com.javaguides.organizationservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrganizationDto {

    private Long id;
    private String organizationName;
    private String organizationDescription;
    private String organizationCode;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
