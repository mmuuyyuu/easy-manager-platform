package com.easy.pojo.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @Packge com.easy.pojo.VO
 * @Autor linNaibin
 * @Description
 * @Version 1.0
 * @Date 2021/2/3 16:36
 */
@Data
public class UserInfoVo implements Serializable {
    private long id ;
    private String userName ;
    private String password ;
}
