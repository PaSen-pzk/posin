package com.posin.blog.security.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkP
 * @date 2024/2/20 20:10
 * @func
 * @description
 */
@Slf4j
public class ServletUtils {

    public static void renderString(HttpServletResponse response, String info) {
        try {
            JSONObject infoJson = JSON.parseObject(info);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(infoJson.getInteger("code"));
            response.getWriter().print(infoJson.getString("msg"));
        } catch (IOException e) {
            log.error("失败", e);
        }
    }
}
