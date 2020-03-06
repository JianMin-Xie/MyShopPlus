package com.xjm.myshop.plus.configuration;

import com.xjm.myshop.plus.interceptor.FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign 全局配置
 * <p>
 * Description:
 * </p>
 *
 * @author xjm
 * @version v1.0.0
 * @see com.xjm.myshop.plus.configuration
 */
@Configuration
public class FeignRequestConfiguration {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestInterceptor();
    }
}