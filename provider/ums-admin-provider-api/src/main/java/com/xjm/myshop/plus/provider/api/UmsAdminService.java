package com.xjm.myshop.plus.provider.api;

import com.xjm.myshop.plus.provider.domain.UmsAdmin;

/**
 * @author xjm
 */
public interface UmsAdminService {

    /**
     * 新增用户
     * @param umsAdmin {@link UmsAdmin}
     * @return 大于 0 则表示注册成功
     */
    int insert(UmsAdmin umsAdmin);

    /**
     * 获取用户
     * @param username 用户名
     * @return {@link UmsAdmin}
     */
    UmsAdmin get(String username);

    UmsAdmin get(UmsAdmin umsAdmin);

    /**
     * 更新个人信息
     * @return
     */
    int update(UmsAdmin umsAdmin);

    /**
     * 修改密码
     * @param username 用户名
     * @param password 明文密码
     * @return 大于 0 表示修改成功
     */
    int modifyPassword(String username, String password);



}
