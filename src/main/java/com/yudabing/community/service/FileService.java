package com.yudabing.community.service;

import com.yudabing.community.dto.FileDTO;
import com.yudabing.community.provider.FtpProvider;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author YuBing
 * @package com.yudabing.community.service
 * @create 2019-08-30 14:55
 * @usage
 **/
@Service
@Slf4j
public class FileService {

    @Autowired
    private FtpProvider ftpProvider;

    @Value("${ftp.server.host}")
    private String host;

    @Value("${ftp.server.port}")
    private int port;

    @Value("${ftp.server.username}")
    private String username;

    @Value("${ftp.server.password}")
    private String password;

    @Value("${ftp.server.basepath}")
    private String basepath;

    @Value("${ftp.server.baseurl}")
    private String baseurl;

    public FileDTO uploadFile(MultipartFile file) {

        FileDTO fileDTO = new FileDTO();
        try {
            StringBuilder fileName = new StringBuilder(ftpProvider.genImageName());

            fileName.append(
                    file.getOriginalFilename().substring(
                            file.getOriginalFilename().lastIndexOf(".")));
            String filePath = new DateTime().toString("/yyyy/MM/dd");
            boolean result = ftpProvider.uploadFile(host, port, username, password, basepath,
                    filePath, fileName.toString(), file.getInputStream());
            if (result) {
                fileDTO.setSuccess(1);
                fileDTO.setUrl(new StringBuilder()
                        .append(baseurl)
                        .append(filePath)
                        .append("/")
                        .append(fileName)
                        .toString());
            } else {
                fileDTO.setSuccess(0);
                fileDTO.setMessage("上传失败！");
            }
            return fileDTO;
        } catch (Exception e) {
            log.error("upload error", e);
            fileDTO.setSuccess(0);
            fileDTO.setMessage("上传发生异常！");
            return fileDTO;
        }

    }

}
