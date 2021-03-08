package com.zrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Controller
public class UploadController {

    @RequestMapping("/fileUpload1")
    public String fileUpload(String picname, MultipartFile uploadFile, HttpServletRequest request) throws Exception {
        String fileName = "";
        //原始的文件名字
        String uploadFileName = uploadFile.getOriginalFilename();
        //2.截取文件扩展名
        String extendName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);

        //3.把文件加上随机数，防止文件重复
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        //4.判断是否输入了文件名
        if (!StringUtils.isEmpty(picname)) {
            fileName = uuid + "_" + picname + "." + extendName;
        } else {
            fileName = uuid + "_" + uploadFileName;
        }
        System.out.println("要上传的文件名是：" + fileName);
        //获取上传的真实的服务器路径
        String basePath = request.getServletContext().getRealPath("/uploads");
        //3.解决同一文件夹中文件过多问题
        String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //4.判断路径是否存在
        File file = new File(basePath + "/" + datePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //5.使用 MulitpartFile 接口中方法，把上传的文件写到指定位置
        File f = new File(file, fileName);
        uploadFile.transferTo(f);
        System.out.println("文件上传成功:" +f.getAbsolutePath());
        return "success";
    }
}
