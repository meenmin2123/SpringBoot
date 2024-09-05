package com.ss.thymeleafProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookStore {

    private String title;
    private String category;
    private int price;
}
