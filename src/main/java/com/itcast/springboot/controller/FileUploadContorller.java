package com.itcast.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author lichunmiao
 * @date 2021/5/15
 */
@Slf4j
@RestController
public class FileUploadContorller {
    /**
     * @RequestParam: 用来将请求参数与方法参数进行映射, 同时也支持表单提交中的参数映射
     * @RequestPart:可用于将“ multipart / form-data”请求的一部分与方法参数关联的注释
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("name") String userName, String age, @RequestPart("head") MultipartFile head, MultipartFile[] photo) throws IOException {
        log.info("年龄为:{}", age);
        log.info("姓名为:{}", userName);
        log.info("头像的大小为:{}", head.getSize());
        log.info("生活照的数量为为:{}", photo.length);
        String fileName = head.getOriginalFilename();
        head.transferTo(new File("D:\\cache\\" + fileName));
        for (MultipartFile multipartFile : photo) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("D:\\cache\\" + originalFilename));
        }
        return "success";
    }
}
