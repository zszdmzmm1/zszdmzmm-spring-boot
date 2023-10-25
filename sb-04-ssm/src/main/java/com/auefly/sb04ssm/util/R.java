package com.auefly.sb04ssm.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {
    private Integer code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public static R ok() {
        return ok(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null);
    }

    public static R ok(Object data) {
        return ok(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    public static R ok(Integer code, String msg, Object data) {
        return new R(code, msg, data);
    }

    public static R fail() {
        return fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), null);
    }

    public static R fail(Integer code, String msg, Object data) {
        return new R(code, msg, data);
    }
}
