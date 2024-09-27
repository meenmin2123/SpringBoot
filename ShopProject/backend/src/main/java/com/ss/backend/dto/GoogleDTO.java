package com.ss.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoogleDTO {
    private String id;
    private String email;
    private String name;
    private String mobile;
}
