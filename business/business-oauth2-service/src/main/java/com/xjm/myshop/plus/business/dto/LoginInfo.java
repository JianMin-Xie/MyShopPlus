package com.xjm.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录信息
 * @author xjm
 */
@Data
public class LoginInfo implements Serializable {
    private String name;
    private String avatar;
}
