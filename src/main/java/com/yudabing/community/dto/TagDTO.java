package com.yudabing.community.dto;

import lombok.Data;

import java.util.List;

/**
 * @author YuBing
 * @package com.yudabing.community.dto
 * @create 2019-08-19 19:18
 **/
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
