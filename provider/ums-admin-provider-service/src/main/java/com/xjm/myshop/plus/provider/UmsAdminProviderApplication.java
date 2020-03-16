package com.xjm.myshop.plus.provider;

import com.xjm.myshop.plus.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackageClasses = {UmsAdminProviderApplication.class,DubboSentinelConfiguration.class})
@MapperScan(basePackages = "com.xjm.myshop.plus.provider.mapper")
public class UmsAdminProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmsAdminProviderApplication.class, args);
    }
}
