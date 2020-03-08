package com.xjm.myshop.plus.business.controller;

import com.xjm.myshop.plus.business.dto.ProfileParam;
import com.xjm.myshop.plus.commons.dto.ResponseResult;
import com.xjm.myshop.plus.provider.api.UmsAdminService;
import com.xjm.myshop.plus.provider.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 个人信息管理
 * <p>
 * Description:
 * </p>
 *
 * @author xjm
 * @version v1.0.0
 * @since 2020-03-06 12:54:05
 * @see com.xjm.myshop.plus.business.controller
 *
 */
@RestController
@RequestMapping(value = "profile")
public class ProfileController {

    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

    @GetMapping(value = "info/{username}")
    public ResponseResult<UmsAdmin> info(@PathVariable String username){
        UmsAdmin umsAdmin = umsAdminService.get(username);
        return new ResponseResult<UmsAdmin>(ResponseResult.CodeStatus.OK,"查询用户信息",umsAdmin);

    }

    /***
     * 更新个人信息
     * @param profileParam
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody ProfileParam profileParam){
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(profileParam, umsAdmin);
        int result = umsAdminService.update(umsAdmin);

        //成功
        if(result > 0){
            return new ResponseResult<Void>(ResponseResult.CodeStatus.OK,"更新个人信息成功");
        }
        //失败
        else{
            return new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL,"更新个人信息失败");
        }

    }


}
