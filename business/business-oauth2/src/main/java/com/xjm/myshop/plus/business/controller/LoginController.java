package com.xjm.myshop.plus.business.controller;

import com.google.common.collect.Maps;
import com.xjm.myshop.plus.business.dto.LoginParam;
import com.xjm.myshop.plus.commons.dto.ResponseResult;
import com.xjm.myshop.plus.commons.utils.MapperUtils;
import com.xjm.myshop.plus.commons.utils.OkHttpClientUtil;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录管理
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {

    private static final String URL_OAUTH_TOKEN="http://localhost:9001/oauth/token";

    @Value("${business.oauth2.grant_type}")
    public String oauth2_grant_type;

    @Value("${business.oauth2.client_id}")
    public String client_id;

    @Value("${business.oauth2.client_secret}")
    public String client_secret;

    @PostMapping(value = "/user/login")
    public ResponseResult<Map<String,Object>> login(@RequestBody LoginParam loginParam){
        Map<String, Object> result = Maps.newHashMap();
        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", oauth2_grant_type);
        params.put("client_id", client_id);
        params.put("client_secret", client_secret);

        try {
            Response response = OkHttpClientUtil.getInstance().postData(URL_OAUTH_TOKEN, params);
            String jsonString = response.body().string();
            Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
            String token = String.valueOf(jsonMap.get("access_token"));
            result.put("token", token);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseResult<Map<String,Object>>(20000,"登录成功",result);
    }
}
