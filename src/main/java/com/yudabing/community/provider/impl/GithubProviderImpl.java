package com.yudabing.community.provider.impl;

import com.alibaba.fastjson.JSON;
import com.yudabing.community.dto.AccessTokenDTO;
import com.yudabing.community.dto.GithubUser;
import com.yudabing.community.provider.GithubProvider;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

/**
 * @author YuBing
 * @package com.yudabing.community.provider
 * @create 2019-08-12 17:34
 **/
@Component
public class GithubProviderImpl implements GithubProvider {

    public String getAccessToken (AccessTokenDTO accessTokenDTO) {
        MediaType mediaType
                = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String str = Objects.requireNonNull(response.body()).string();
            String accesstoken = str.split("&")[0].split("=")[1];
            System.out.println(accesstoken);
            return accesstoken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getGithubUser (String accesstoken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accesstoken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String str = Objects.requireNonNull(response.body()).string();
            return JSON.parseObject(str, GithubUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
