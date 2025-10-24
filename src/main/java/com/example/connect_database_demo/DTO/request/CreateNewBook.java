package com.example.connect_database_demo.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewBook {
    private String title;
    private String author;
    private String description;
}
