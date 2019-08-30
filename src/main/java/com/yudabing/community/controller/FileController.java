package com.yudabing.community.controller;

import com.yudabing.community.dto.FileDTO;
import com.yudabing.community.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YuBing
 * @package com.yudabing.community.controller
 * @create 2019-08-27 16:52
 * @usage
 **/
@Controller
public class FileController {

    @Autowired
    private FileService fileService;



    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(HttpServletRequest request) {

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartHttpServletRequest.getFile("editormd-image-file");
        return fileService.uploadFile(file);
    }
}
