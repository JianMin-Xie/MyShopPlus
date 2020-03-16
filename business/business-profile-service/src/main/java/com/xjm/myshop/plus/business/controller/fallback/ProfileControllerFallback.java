package com.xjm.myshop.plus.business.controller.fallback;

import com.xjm.myshop.plus.business.dto.UmsAdminDTO;
import com.xjm.myshop.plus.business.feign.fallback.ProfileFeignFallback;
import com.xjm.myshop.plus.commons.dto.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jm
 * @create 2020-03-16 16:40
 */
public class ProfileControllerFallback {
    private static final Logger logger = LoggerFactory.getLogger(ProfileControllerFallback.class);
    /**
     * 熔断方法
     *
     * @param username {@code String} 用户名
     * @return {@link ResponseResult<UmsAdminDTO>}
     */
    public static ResponseResult<UmsAdminDTO> infoFallback(String username, Throwable ex) {
        logger.warn("Invoke infoFallback: " + ex.getClass().getTypeName());
        ex.printStackTrace();
        return new ResponseResult<UmsAdminDTO>(ResponseResult.CodeStatus.BREAKING, ProfileFeignFallback.BREAKING_MESSAGE);
    }
}
