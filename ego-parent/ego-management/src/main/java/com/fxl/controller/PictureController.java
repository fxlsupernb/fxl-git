package com.fxl.controller;

import com.fxl.pojo.Picture;
import com.fxl.service.PictureService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author FanXingLong
 * @date 2020-06-17
 */
@Controller
public class PictureController {

    @Resource
    private PictureService pictureServiceImpl;

    @RequestMapping("/show")
    public String show(Model model){
        List<Picture> pictures = pictureServiceImpl.selAll();
        model.addAttribute("pictures",pictures);
        return "show.jsp";
    }

    @RequestMapping("/insert")
    public String insert(MultipartFile file, HttpServletRequest req){
        String tagerPath =file.getOriginalFilename();
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(req.getServletContext().getRealPath("/files"),tagerPath));
            pictureServiceImpl.insPic(tagerPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/show";
    }

    @RequestMapping("/delete")
    public String delete(int id){
        pictureServiceImpl.delPic(id);
        return "redirect:/show";
    }
}
