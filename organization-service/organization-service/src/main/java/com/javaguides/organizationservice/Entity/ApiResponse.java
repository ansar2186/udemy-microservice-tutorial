package com.javaguides.organizationservice.Entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ApiResponse {
    public String message;
    public boolean success;
}
