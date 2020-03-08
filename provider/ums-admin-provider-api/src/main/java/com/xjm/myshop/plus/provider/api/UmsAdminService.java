package com.xjm.myshop.plus.provider.api;

import com.xjm.myshop.plus.provider.domain.UmsAdmin;

public interface UmsAdminService {

    /**
     * 新增用户
     * @param umsAdmin {@link UmsAdmin}
     * @return 大于 0 则表示注册成功
     */
    int insert(UmsAdmin umsAdmin);

    /**
     * 获取影虎
     * @param username 用户名
     * @return {@link UmsAdmin}
     */
    UmsAdmin get(String username);

    UmsAdmin get(UmsAdmin umsAdmin);

    /**
     * 更新
     * @return
     */
    int update(UmsAdmin umsAdmin);

}
