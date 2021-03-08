package com.zrs.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Controller("springMVCUpload")
public class springMVCUploadController {
    public static final String FILESERVERURL = "http://localhost:8089/fileupload/uploads/";

    /**
     * 文件上传，保存文件到不同服务器
     */
    @RequestMapping("/fileUpload2")
    public String testResponseJson(String picname, MultipartFile
            uploadFile) throws
            Exception {
        //定义文件名
        String fileName = "";
        //1.获取原始文件名
        String uploadFileName = uploadFile.getOriginalFilename();
        //2.截取文件扩展名
        String extendName =
                uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
        //3.把文件加上随机数，防止文件重复
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        //4.判断是否输入了文件名
        if (!StringUtils.isEmpty(picname)) {
            fileName = uuid + "_" + picname + "." + extendName;
        } else {
            fileName = uuid + "_" + uploadFileName;
        }
        System.out.println(fileName);
        //5.创建 sun 公司提供的 jersey 包中的 Client 对象
        Client client = Client.create();
        //6.指定上传文件的地址，该地址是 web 路径
        WebResource resource = client.resource(FILESERVERURL + fileName);
        //7.实现上传
        String result = resource.put(String.class, uploadFile.getBytes());
        System.out.println(result);
        return "success";
    }
}
