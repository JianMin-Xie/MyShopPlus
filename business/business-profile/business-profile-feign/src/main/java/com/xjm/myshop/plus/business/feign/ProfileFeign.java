package com.xjm.myshop.plus.business.feign;

import com.xjm.myshop.plus.business.dto.ProfileParam;
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
@FeignClient(value = "business-profile",path = "profile", configuration = FeignRequestConfiguration.class)
public interface ProfileFeign {

    @GetMapping(value = "info/{username}")
    String info(@PathVariable String username);

    @PostMapping(value = "update")
    String update(@RequestBody ProfileParam profileParam);

}
