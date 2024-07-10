package com.posin.common.core.web.controller;

import com.github.pagehelper.PageInfo;
import com.posin.common.core.constant.HttpStatus;
import com.posin.common.core.utils.DateUtils;
import com.posin.common.core.utils.PageUtils;
import com.posin.common.core.web.domain.R;
import com.posin.common.core.web.page.TableDataInfo;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

/**
 * web层通用数据处理
 *
 * @author ruoyi
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageUtils.startPage();
    }

    /**
     * 清理分页的线程变量
     */
    protected void clearPage()
    {
        PageUtils.clearPage();
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setRows(list);
        rspData.setMsg("查询成功");
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 返回成功
     */
    public R success()
    {
        return R.success();
    }

    /**
     * 返回成功消息
     */
    public R success(String message)
    {
        return R.success(message);
    }

    /**
     * 返回成功消息
     */
    public R success(Object data)
    {
        return R.success(data);
    }

    /**
     * 返回失败消息
     */
    public R error()
    {
        return R.error();
    }

    /**
     * 返回失败消息
     */
    public R error(String message)
    {
        return R.error(message);
    }

    /**
     * 返回警告消息
     */
    public R warn(String message)
    {
        return R.warn(message);
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected R toAjax(int rows)
    {
        return rows > 0 ? R.success() : R.error();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected R toAjax(boolean result)
    {
        return result ? success() : error();
    }
}
