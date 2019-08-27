package com.yudabing.community.dto;

import lombok.Data;

/**
 * @author YuBing
 * @package com.yudabing.community.dto
 * @create 2019-08-27 13:55
 * @usage
 **/
@Data
public class NotificationDTO {
    private Integer id;
    private Long gmtCreate;
    private Integer status;
    private Integer notifier;
    private String notifierName;
    private String outerTitle;
    private Integer outerid;
    private String typeName;
    private Integer type;
}
