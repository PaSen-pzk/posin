package com.posin.blog.vo;

import com.posin.blog.constants.Constants;
import com.posin.common.core.constant.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

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

    private String code = HttpStatus.SUCCESS;

    private String message = Constants.Msg.SUCCESS;

    private T data;

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static StdResultVo success()
    {
        return StdResultVo.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static StdResultVo success(Object data)
    {
        return StdResultVo.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static StdResultVo success(String msg)
    {
        return StdResultVo.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static StdResultVo success(String msg, Object data)
    {
        return new StdResultVo(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static StdResultVo warn(String msg)
    {
        return StdResultVo.warn(msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static StdResultVo warn(String msg, Object data)
    {
        return new StdResultVo(HttpStatus.WARN, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return 错误消息
     */
    public static StdResultVo error()
    {
        return StdResultVo.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 错误消息
     */
    public static StdResultVo error(String msg)
    {
        return StdResultVo.error(HttpStatus.ERROR, msg);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 错误消息
     */
    public static StdResultVo error(String msg, Object data)
    {
        return new StdResultVo(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg 返回内容
     * @return 错误消息
     */
    public static StdResultVo error(String code, String msg)
    {
        return new StdResultVo(code, msg, null);
    }

    /**
     * 是否为成功消息
     *
     * @return 结果
     */
    public boolean isSuccess()
    {
        return Objects.equals(HttpStatus.SUCCESS, this.code);
    }

    /**
     * 是否为警告消息
     *
     * @return 结果
     */
    public boolean isWarn()
    {
        return Objects.equals(HttpStatus.WARN, this.code);
    }

    /**
     * 是否为错误消息
     *
     * @return 结果
     */
    public boolean isError()
    {
        return Objects.equals(HttpStatus.ERROR, this.code);
    }
}
