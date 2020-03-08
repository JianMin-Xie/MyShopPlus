package com.xjm.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 个人信息参数
 * <p>
 * Description:
 * </p>
 *
 * @author xjm
 * @version v1.0.0
 * @since 2020-03-08 18:42:24
 * @see com.xjm.myshop.plus.business.dto
 *
 */
@Data
public class ProfileParam implements Serializable {
    private Long id;

    private String username;

    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 备注信息
     */
    private String note;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后登录时间
     */
    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private Integer status;
}
