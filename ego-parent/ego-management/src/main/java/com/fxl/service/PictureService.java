package com.fxl.service;

import com.fxl.pojo.Picture;

import java.util.List;

/**
 * @author FanXingLong
 * @date 2020-06-17
 */
public interface PictureService {

    List<Picture> selAll();

    int insPic(String filePath);

    int delPic(int id);
}
