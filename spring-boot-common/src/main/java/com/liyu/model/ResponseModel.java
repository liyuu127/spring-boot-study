package com.liyu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel<T> {
    private Integer ststus;
    private String message;
    private T data;

    public ResponseModel(ResponseEnum responseEnum, T data) {
        this.ststus =responseEnum.getStatus();
        this.message =responseEnum.getMessage();
        this.data = data;
    }
}
