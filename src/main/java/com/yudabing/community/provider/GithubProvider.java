package com.yudabing.community.provider;


import com.yudabing.community.dto.AccessTokenDTO;
import com.yudabing.community.dto.GithubUser;




/**
 * @author YuBing
 * @package com.yudabing.community.provider
 * @create 2019-08-12 16:31
 **/

public interface GithubProvider {
    public String getAccessToken (AccessTokenDTO accessTokenDTO);
    public GithubUser getGithubUser (String accesstoken);
}
