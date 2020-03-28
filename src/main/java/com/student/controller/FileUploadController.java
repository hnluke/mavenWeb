package com.student.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {
    /**
     * 文件上传
     * @param id 保存文件的id名
     * @param other
     * @param file 上传的文件
     * @param request
     * @return
     */
    @RequestMapping(value="/fileUpload/{id}")
    public String fileUpload(@PathVariable("id") String id, String other,
                             MultipartFile file, HttpServletRequest request) {
        String path= "";
        // 获取要上传的文件名
        String fileName= file.getOriginalFilename();
        String suffix = fileName.substring(fileName.indexOf('.'));
        path = request.getServletContext().getRealPath("");
        path = path + "files\\" + id + suffix;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "success";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("fileName") String fileName, HttpServletRequest req)
            throws IOException {

        // 获取文件存放的真实路径
        //String realPath = req.getServletContext().getRealPath("/WEB-INF/views");
        String realPath = req.getServletContext().getRealPath("/files");
        System.out.println(realPath);
        //创建文件实例
        File file = new File(realPath, fileName);
        //修改文件名的编码格式
        String downloadFileName = new String(fileName.getBytes("UTF-8"), "UTF-8");

        //设置httpHeaders,使浏览器响应下载
        HttpHeaders headers = new HttpHeaders();
        //告诉浏览器执行下载的操作，“attachment”告诉了浏览器进行下载,下载的文件 文件名为 downloadFileName
        headers.setContentDispositionFormData("attachment", downloadFileName);
        //设置响应方式为二进制，以二进制流传输
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

}
