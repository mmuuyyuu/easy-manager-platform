package com.easy.enums;


import com.easy.result.ErrorCode;

/**
 * @author linNaibin
 * @version V1.0
 * @Title:
 * @Package com.easy.enums
 * @Description: 定义返回结果
 * @date 2021年2月10日 上午11:54:24
 */
public enum EasyResultEnums implements ErrorCode {

    SUCCESS(1, "操作成功"), FAILED(0, "操作失败"), VALIDATE_FAILED(2, "参数检验失败"),ERROR_PARAMS(3,"错误的参数."), MISS_PARAMS(6, "缺少参数"), UNKNOWN(999, "未知的错误");

    EasyResultEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String msg() {

        return this.msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

}
