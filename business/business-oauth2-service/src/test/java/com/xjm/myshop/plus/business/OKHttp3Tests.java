package com.xjm.myshop.plus.business;

import com.google.common.collect.Maps;
import com.xjm.myshop.plus.commons.utils.MapperUtils;
import com.xjm.myshop.plus.commons.utils.OkHttpClientUtil;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OKHttp3Tests {

    @Test
    public void testGet() {
        String url = "https://www.baidu.com";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        String url = "http://localhost:9001/oauth/token";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("username", "admin")
                .add("password", "123456")
                .add("grant_type", "password")
                .add("client_id", "client")
                .add("client_secret", "secret")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUtilPost() {
        String url = "http://localhost:9001/oauth/token";
        Map<String, String> params = Maps.newHashMap();
        params.put("username", "admin");
        params.put("password", "123456");
        params.put("grant_type", "password");
        params.put("client_id", "client");
        params.put("client_secret", "secret");

        try {
            Response response = OkHttpClientUtil.getInstance().postData(url, params);
            String jsonString = response.body().string();
            Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
            String access_token = String.valueOf(jsonMap.get("access_token"));
            System.out.println(access_token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
