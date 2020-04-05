package com.machun.srpingbootupload.controller;

import com.machun.srpingbootupload.vo.ResponseJsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author machun1
 */
@Controller
@RequestMapping("file")
@ResponseBody
@PropertySource({"classpath:application.properties"})
public class FileController {
    @Value("${upload.path}")
    public String imgSavePath;

    @RequestMapping("upload")
    public ResponseJsonData uploadFile(@RequestParam("up_file") MultipartFile file, HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        String fileName = file.getOriginalFilename();
        System.out.println("上传人：" + name);
        System.out.println("原始上传文件大小：" + file.getSize());
        System.out.println("原始上传文件名：" + fileName);
        System.out.println("上传时间：" + LocalDateTime.now());
        System.out.println("存储路径：" + imgSavePath);

        if (!new File(imgSavePath).exists()) {
            new File(imgSavePath).mkdir();
        }

        File destFile = new File(imgSavePath + fileName);

        HashMap map = new HashMap(16);
        map.put("fileName", fileName);
        map.put("fileSize", file.getSize());
        map.put("filePath", destFile.getPath());

        file.transferTo(destFile);
        return new ResponseJsonData("200", "ok", map);

    }

    @RequestMapping("multiupload")
    public ResponseJsonData multiUpload(@RequestParam("up_file") MultipartFile[] files, HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        for (MultipartFile file : files
        ) {

            String fileName = file.getOriginalFilename();
            System.out.println("上传人：" + name);
            System.out.println("原始上传文件大小：" + file.getSize());
            System.out.println("原始上传文件名：" + fileName);
            System.out.println("-----------------------------------------");
        }


        if (!new File(imgSavePath).exists()) {
            new File(imgSavePath).mkdir();
        }

        List<HashMap> fileList = new ArrayList<>();
        for (MultipartFile file : files) {

            File destFile = new File(imgSavePath + file.getOriginalFilename());

            HashMap map = new HashMap(16);
            map.put("fileName", file.getOriginalFilename());
            map.put("fileSize", file.getSize());
            map.put("filePath", destFile.getPath());
            fileList.add(map);
            file.transferTo(destFile);
        }
        return new ResponseJsonData("200", "ok", fileList);


    }
}
