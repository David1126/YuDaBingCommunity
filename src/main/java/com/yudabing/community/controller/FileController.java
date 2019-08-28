package com.yudabing.community.controller;

import com.yudabing.community.dto.FileDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author YuBing
 * @package com.yudabing.community.controller
 * @create 2019-08-27 16:52
 * @usage
 **/
@Controller
public class FileController {
    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload() {
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("/images/pay.png");
        return fileDTO;
    }
}
