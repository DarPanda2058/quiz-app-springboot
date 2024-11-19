package com.darpan.quizzapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor //provides parameterized and default constructor for the class.
public class Response {
    private Integer id;
    private String response;
}
