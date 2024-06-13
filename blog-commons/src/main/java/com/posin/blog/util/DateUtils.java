package com.posin.blog.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author zkP
 * @date 2024/2/19 22:44
 * @func
 * @description
 */
public class DateUtils {


    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
