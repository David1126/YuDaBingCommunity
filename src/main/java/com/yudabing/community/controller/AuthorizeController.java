package com.yudabing.community.controller;

import com.yudabing.community.dto.AccessTokenDTO;
import com.yudabing.community.dto.GithubUser;
import com.yudabing.community.mapper.UserMapper;
import com.yudabing.community.model.User;
import com.yudabing.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author YuBing
 * @package com.yudabing.community.controller
 * @create 2019-08-12 16:11
 **/
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private String client_id;

    @Value("${github.client.secret}")
    private String client_secret;

    @Value("${github.redirect.url}")
    private String redirect_url;

    @RequestMapping("/callback")
    public String callback (@RequestParam(name = "state") String state,
                            @RequestParam(name = "code") String code,
                            HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_url);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getGithubUser(accessToken);
        //System.out.println(githubUser);
        if (githubUser != null && githubUser.getId() != null) {
            User user = new User();
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setName(githubUser.getName());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(System.currentTimeMillis());
            user.setAvatarUrl(githubUser.getAvatarUrl());
            userMapper.insert(user);

            response.addCookie(new Cookie("token", token));

            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

}
