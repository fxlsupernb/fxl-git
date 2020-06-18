package com.fxl.controller;

import com.fxl.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author FanXingLong
 * @date 2020-06-17
 */
@Controller
public class PictureController {

    @Resource
    private PictureService pictureServiceImpl;

    @RequestMapping("/")
    public String show(Model model){
        model.addAttribute("pictures",pictureServiceImpl.selAll());
        return "main.jsp";
    }
}
