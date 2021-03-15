package com.example.shop.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignRequest {

    @NotBlank
    private String account;

    @NotBlank
    private String pwd;
}
