package com.posin.blog.vo;

import com.posin.blog.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zkP
 * @date 2024/2/20 20:11
 * @func
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultVo<T> implements Serializable {

    private String code;
    private T data;
    private String msg;

    public static <T> ResultVo<T> error(String code, String msg) {
        return (ResultVo<T>) ResultVo.builder().code(code).msg(msg).build();
    }

    public static <T> ResultVo<T> success(Object obj) {
        return (ResultVo<T>) ResultVo.builder().code(Constants.Code.SUCCESS).msg(Constants.Msg.SUCCESS).data(obj).build();
    }

    public static <T> ResultVo<T> success(String code) {
        return (ResultVo<T>) ResultVo.builder().code(code).build();
    }
}
