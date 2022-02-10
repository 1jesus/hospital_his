package com.zhiyou.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @Classname FileUploadUtil
 * @Date 2021/12/21 19:42
 */
@Component
public class FileUploadUtil {
    /**
     * 文件上传
     */
    public String upload(HttpServletRequest request) {
        // 从请求中获得文件对象
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;

        // 获得具体的文件,参数名一定与前端name属性一致
        MultipartFile file = req.getFile("file");

        // 确定服务器位置
        ServletContext servletContext = request.getServletContext();
        // 获得服务器/images文件路径,将来图片就存储在服务器的/images
        String realPath = servletContext.getRealPath("/images");
        File parent = new File(realPath);//
        if (!parent.exists()) {
            parent.mkdir();
        }

        // 获得文件名
        String originalFilename = file.getOriginalFilename();
        // 获得文件名后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        long millis = System.currentTimeMillis();

        // 组装文件名
        String fileName = millis + suffix;
        File targetFile = new File(parent, fileName);
        System.out.println("最终的文件名: fileName = " + targetFile);

        // 执行上传
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            System.out.println(">>>>>上传文件失败<<<<<");
            e.printStackTrace();
        }
        String url = "images/" + fileName;
        System.out.println("上传成功!!!");
        return url;
    }

}

