package com.qf.controller;

import com.qf.pojo.Goods;
import com.qf.service.GoodsService;
import com.qf.utils.UpLoadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * create by  by 2018/4/16
 * 备注:图片上传
 * @author l姚超杰
 */
@RestController
@RequestMapping("goodUpdate")
public class FileUploadController {
    private final GoodsService goodsService;

    @Autowired
    public FileUploadController(GoodsService service) {
        this.goodsService = service;
    }

    /**
     * 文件上传
     * @param file 文件
     * @param id 商品id
     * @return string 文件路径
     */
    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file,int id) throws IOException {

        String baseDir="D:/tmp";
        String path;
        if (file != null && file.getName() != null && !file.isEmpty()) {
            String oldFileName = file.getOriginalFilename();
            if(oldFileName!=null&&!"".equals(oldFileName.trim())) {
                String newFileName = UpLoadUtils.getFileName(oldFileName);
                //2得到新的路径
                String filepath = UpLoadUtils.getDir(baseDir, newFileName);
                //3保存
                File file1 = new File(filepath, newFileName);

                    file.transferTo(file1);
                     path="\\pic"+file1.getAbsolutePath().substring(6);
                    Goods goods=new Goods();
                    goods.setPicture(path);
                    goods.setId(id);
                   if(goodsService.goodPicUpdate(goods)){
                       return path;
                   }
            }
        }
        return "";
    }
}
