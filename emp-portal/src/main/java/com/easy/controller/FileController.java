package com.easy.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.easy.result.EasyResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @Packge com.easy.controller
 * @Autor linNaibin
 * @Description 文件管理
 * @Version 1.0
 * @Date 2021/2/4 10:05
 */
@RequestMapping("/file")
@Api(tags = "文件管理模块")
@Controller
public class FileController {

    private static final Logger LOG = LoggerFactory.getLogger(FileController.class);

    MultipartConfigElement multipartConfigElement;

    @Autowired
    FileController(MultipartConfigElement multipartConfigElement) {
        this.multipartConfigElement = multipartConfigElement;
    }

    @ApiOperation(value = "测试", notes = "测试")
    @ResponseBody
    @PostMapping("/demo" )
    public EasyResult<JSONArray> test(String s) {

        System.out.println(" demo ____ "  + s);
        return EasyResult.success(null);
    }

    @ApiOperation(value = "文件上传", notes = "Springboot 文件上传")
    @ResponseBody
    @PostMapping("/upload")
    public EasyResult<JSONArray> upload(@RequestParam("files") MultipartFile files[], HttpServletRequest request) {

        LOG.info("开始上传文件..");

        JSONArray fileNameArray = new JSONArray();

        for (int i = 0; i < files.length; i++) {
            String fileName = files[i].getOriginalFilename();  // 文件名

            // 存放路径。
            File dest = new File(multipartConfigElement.getLocation() + File.separator + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                files[i].transferTo(dest);
                fileNameArray.add(fileName);
            } catch (Exception e) {
                LOG.error("{}", e);
                return EasyResult.failed();
            }
        }

            return EasyResult.success(fileNameArray);
    }
}
