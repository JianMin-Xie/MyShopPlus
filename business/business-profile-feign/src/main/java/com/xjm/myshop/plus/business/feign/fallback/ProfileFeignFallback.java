package com.xjm.myshop.plus.business.feign.fallback;

import com.xjm.myshop.plus.business.dto.UmsAdminDTO;
import com.xjm.myshop.plus.business.dto.params.IconParam;
import com.xjm.myshop.plus.business.dto.params.PasswordParam;
import com.xjm.myshop.plus.business.dto.params.ProfileParam;
import com.xjm.myshop.plus.business.feign.ProfileFeign;
import com.xjm.myshop.plus.commons.dto.ResponseResult;
import com.xjm.myshop.plus.commons.utils.MapperUtils;
import org.springframework.stereotype.Component;

/**
 * 个人信息服务熔断器
 * @author Jm
 * @create 2020-03-14 21:40
 */
@Component
public class ProfileFeignFallback implements ProfileFeign {

    public static final String BREAKING_MESSAGE="请求失败了，请检查您的网络";

    @Override
    public String info(String username) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(ResponseResult.CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String update(ProfileParam profileParam) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(ResponseResult.CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String modifyPassword(PasswordParam passwordParam) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(ResponseResult.CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String modifyIcon(IconParam iconParam) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(ResponseResult.CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
