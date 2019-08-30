package com.yudabing.community.provider;

import java.io.InputStream;

/**
 * @author YuBing
 * @package com.yudabing.community.provider
 * @create 2019-08-29 15:30
 * @usage
 **/
public interface FtpProvider {
    public boolean uploadFile(String host, int port, String username, String password, String basePath,
                                     String filePath, String filename, InputStream input);

    public boolean downloadFile(String host, int port, String username, String password, String remotePath,
                                       String fileName, String localPath);
    public String genImageName();
}
