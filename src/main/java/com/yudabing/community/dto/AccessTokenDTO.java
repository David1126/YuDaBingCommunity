package com.yudabing.community.dto;

import lombok.Data;

/**
 * @author YuBing
 * @package com.yudabing.community.dto
 * @create 2019-08-12 16:31
 **/
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
