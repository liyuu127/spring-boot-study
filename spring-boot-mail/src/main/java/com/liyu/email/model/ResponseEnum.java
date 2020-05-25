package com.liyu.email.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResponseEnum {
    EMAIL_SEND_SUCCESS(200,"邮件发送成功"),
    EMAIL_SEND_FAIL(404,"邮件发送失败"),
    ;
    Integer status;
    String message;
}
