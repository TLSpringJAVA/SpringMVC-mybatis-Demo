package com.anlu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    @RequestMapping(value = "/toupload")
    public String toView(){
        return "home/uploadfile";
    }


    @RequestMapping("/uploadpic")
    public String uploadItem(
            Model model,
            HttpServletRequest request,
            Integer id,
            @ModelAttribute("items") MultipartFile items_pic
    )throws Exception {
        //原始名称
        String originalFilename = items_pic.getOriginalFilename();
//上传图片
        if(items_pic!=null && originalFilename!=null && originalFilename.length()>0){

            //存储图片的物理路径 /Users/anlu/Developer/img
//            String pic_path = "D:\\tmp\\";
            String pic_path = "/Users/anlu/Developer/img/";

            //新的图片名称
//            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = originalFilename;

            //新图片
            File newFile = new File(pic_path+newFileName);

            //将内存中的数据写入磁盘
            items_pic.transferTo(newFile);

            //将新图片名称写到itemsCustom中


        }
        return "home/uploadfile";
    }


    @RequestMapping(value = "/springUpload",method = RequestMethod.POST)
    public String springUpload(HttpServletRequest request,
                               Model model,
                               @RequestParam("description") String description,
                               @RequestParam("file")MultipartFile file)throws Exception{

        System.out.println(description);
        if(!file.isEmpty()){
            //上传文件路径
            //上传文件名
            String path = "/Users/anlu/Developer/img/";
            String originalFilename = file.getOriginalFilename();

            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));


            File filepath = new File(path,newFileName);
            //判断路径是否存在
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            //将文件上传到一个目标文件夹中
            File newFile = new File(path+newFileName);
            //将内存中的数据写入磁盘
            file.transferTo(newFile);
            //将item添加到model
            model.addAttribute("item","图片上传成功了");
            model.addAttribute("picurl",newFileName);
            return "home/uploadfile";

        }else{
            return "error";
        }


    }
}
