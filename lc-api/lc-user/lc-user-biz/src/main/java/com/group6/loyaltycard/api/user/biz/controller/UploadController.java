package com.group6.loyaltycard.api.user.biz.controller;

import com.group6.loyaltycard.api.common.constant.enums.CommonEnums;
import com.group6.loyaltycard.api.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/storage/local")
@Api(value = "UploadController", tags = {"Local upload module interface"})
public class UploadController {

    @Value("${server.port}")
    private String port;

    private final String ip = "http://127.0.0.1";

    /**
     * file upload
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation(value = "upload interface")
    public Result upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws FileNotFoundException {
        String host = ip + ":" + port;
        try {
            //Get the storage location of the file on the server
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            File filePath = new File(path.getAbsolutePath(), "static/upload/");
            log.info("File save path:" + filePath.getAbsolutePath());
            if (!filePath.exists() && !filePath.isDirectory()) {
                log.info("The directory does not exist, create the directory:" + filePath);
                filePath.mkdir();
            }

            //Get the original file name (including formatting)
            String originalFileName = file.getOriginalFilename();
            log.info("Original file name:" + originalFileName);

            //Get the file type, identified by the last `.`
            String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            log.info("file type:" + type);

            //Set the new name of the file
            String fileName = ((long) ((Math.random() + 1) * 100000000)) + "." + type;
            log.info("New file name:" + fileName);

            //Create a file under the specified path
            File targetFile = new File(filePath, fileName);

            //Save the file to the specified location on the server
            file.transferTo(targetFile);
            log.info("uploaded successfully");
            //Return the storage path of the file on the server

            Map map = new HashMap<>();
            map.put("name", fileName);
            map.put("url", host + "/upload/" + fileName);

            return new Result(map);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(CommonEnums.SYSTEM_ERROR);
        }
    }
}
