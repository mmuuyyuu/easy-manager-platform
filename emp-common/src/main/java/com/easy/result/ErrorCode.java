package com.easy.result;

/**
 * @Packge com.easy.result
 * @Autor linNaibin
 * @Description
 * @Version 1.0
 * @Date 2020/11/24 17:05
 */
public interface ErrorCode {

    int code();

    String msg();

    void setCode(int code);

    void setMsg(String msg);

}
