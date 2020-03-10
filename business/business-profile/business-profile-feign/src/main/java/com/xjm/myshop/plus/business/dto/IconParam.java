package com.xjm.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 头像参数
 * <p>
 * Description:
 * </p>
 *
 * @author xjm
 * @version v1.0.0
 * @since 2020-03-10 18:29:45
 * @see com.xjm.myshop.plus.business.dto
 *
 */
@Data
public class IconParam implements Serializable {

    private String username;
    private String path;

}
