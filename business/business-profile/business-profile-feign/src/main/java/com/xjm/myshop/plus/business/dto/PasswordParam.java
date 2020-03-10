package com.xjm.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 修改密码参数
 * <p>
 * Description:
 * </p>
 *
 * @author xjm
 * @version v1.0.0
 * @since 2020-03-10 17:36:03
 * @see com.xjm.myshop.plus.business.dto
 *
 */
@Data
public class PasswordParam implements Serializable {
    private String username;
    private String oldPassword;
    private String newPassword;

}
