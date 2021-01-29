package com.example.shop.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回
 *
 * @author ZYIMM
 */
@Data
public class Result implements Serializable {

    private int code; // 200是正常，非200表示异常
    private String msg;
    private Object result;

    /**
     * success
     *
     * @param data 数据
     * @return Result
     * @author zyimm
     */
    public static Result success(Object data) {
        return success(200, "操作成功", data);
    }

    public static Result success(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setResult(data);
        return result;
    }

    public static Result fail(String msg) {
        return fail(400, msg, null);
    }

    public static Result fail(String msg, Object data) {
        return fail(400, msg, data);
    }

    public static Result fail(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setResult(data);
        return result;
    }
}
