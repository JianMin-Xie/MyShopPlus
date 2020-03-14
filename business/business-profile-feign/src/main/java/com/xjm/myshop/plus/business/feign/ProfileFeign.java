package com.xjm.myshop.plus.business.feign;

import com.xjm.myshop.plus.business.dto.params.IconParam;
import com.xjm.myshop.plus.business.dto.params.PasswordParam;
import com.xjm.myshop.plus.business.dto.params.ProfileParam;
import com.xjm.myshop.plus.business.feign.fallback.ProfileFeignFallback;
import com.xjm.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 
 * <p>
 * Description:
 * </p>
 * 
 * @author xjm
 * @version v1.0.0
 * @since 2020-03-06 12:58:58
 * @see com.xjm.myshop.plus.business.feign
 *
 */
@FeignClient(value = "business-profile",path = "profile", configuration = FeignRequestConfiguration.class,fallback = ProfileFeignFallback.class)
public interface ProfileFeign {

    /**
     * 获取个人信息
     * @param username 用户名
     * @return JSON
     */
    @GetMapping(value = "info/{username}")
    String info(@PathVariable String username);

    /**
     * 更新个人信息
     * @param profileParam {@link ProfileParam}
     * @return JSON
     */
    @PostMapping(value = "update")
    String update(@RequestBody ProfileParam profileParam);

    /**
     * 修改密码
     * @param passwordParam {@link PasswordParam}
     * @return JSON
     */
    @PostMapping(value = "modify/password")
    String modifyPassword(@RequestBody PasswordParam passwordParam);

    /**
     * 修改头像
     * @param iconParam
     * @return
     */
    @PostMapping(value = "modify/icon")
    String modifyIcon(@RequestBody IconParam iconParam);

}
