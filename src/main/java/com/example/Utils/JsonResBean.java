package com.example.Utils;

import lombok.Data;

/**
 * 通用响应
 */
@Data
public class JsonResBean {
    /**
     * JSON消息头 CODE
     */
    private int code = 0;
    /**
     * JSON消息头 错误信息
     */
    private String errorDescription;
    /**
     * JSON消息体
     */
    private Object dataObject;
}
