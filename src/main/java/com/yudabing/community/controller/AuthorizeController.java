package com.yudabing.community.controller;

import com.alibaba.fastjson.JSON;
import com.yudabing.community.dto.AccessTokenDTO;
import com.yudabing.community.dto.GithubUser;
import com.yudabing.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * @author YuBing
 * @package com.yudabing.community.controller
 * @create 2019-08-12 16:11
 **/
@Controller
public class AuthorizeController {

    @Autowired
    GithubProvider githubProvider;

    @RequestMapping("/callback")
    public String callback (@RequestParam(name = "state") String state,
                            @RequestParam(name = "code") String code) throws IOException {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("d27263e370d16a3188ce");
        accessTokenDTO.setClient_secret("3cb4e7303fe6b3653be44a7b553b24555748a952");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getGithubUser(accessToken);
        System.out.println(JSON.toJSONString(githubUser));
        return "index";
    }

}
