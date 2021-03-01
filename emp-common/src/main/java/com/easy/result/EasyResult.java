package com.easy.result;


import com.easy.enums.EasyResultEnums;

/**
 * @Packge com.easy
 * @Autor linNaibin
 * @Description
 * @Version 1.0
 * @Date 2021/2/02 17:06
 */
public class EasyResult<T> {

    private int code;

    private String msg;

    private T data;

    public EasyResult() {

    }

    protected EasyResult(EasyResultEnums result, T data) {
        this.code = result.code();
        this.msg = result.msg();
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> EasyResult<T> success(T data) {
        return new EasyResult<T>(EasyResultEnums.SUCCESS, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误
     */
    public static <T> EasyResult<T> failed(EasyResultEnums errorCode) {
        return new EasyResult<T>(errorCode, null);
    }

    /**
     * 失败返回结果
     *
     * @param message 错误信息
     */
    public static <T> EasyResult<T> failed(String message) {
        EasyResultEnums fial = EasyResultEnums.FAILED;
        fial.setMsg(message);
        return new EasyResult<T>(fial, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> EasyResult<T> failed() {
        return failed(EasyResultEnums.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> EasyResult<T> validateFailed() {
        return failed(EasyResultEnums.VALIDATE_FAILED);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {

        return "[code:" + getCode() + "][msg:" + getMsg() + "][data:" + getData() + "]";
    }

}
