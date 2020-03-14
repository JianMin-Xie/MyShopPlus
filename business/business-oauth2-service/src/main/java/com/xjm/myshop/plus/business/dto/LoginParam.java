package com.xjm.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录菜蔬
 * <p>
 * Description:
 * </p>
 *
 * @author xjm
 * @version v1.0.0
 * @since 2020-03-05 16:02:20
 * @see com.xjm.myshop.plus.business.dto
 *
 */
@Data
public class LoginParam implements Serializable {

    private String username;
    private String password;

}
