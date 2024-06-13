package com.posin.blog.vo;

import com.posin.blog.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zkP
 * @date 2024/1/22 23:10
 * @func
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StdResultVo<T> {

    private String code = Constants.Code.SUCCESS;

    private String message = Constants.Msg.SUCCESS;

    private T data;
}
