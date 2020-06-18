package com.fxl.service.impl;

import com.fxl.mapper.PictureMapper;
import com.fxl.pojo.Picture;
import com.fxl.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author FanXingLong
 * @date 2020-06-17
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Resource
    private PictureMapper pictureMapper;

    public List<Picture> selAll() {
        return pictureMapper.selAll();
    }

    public int insPic(String filePath) {
        Picture picture = new Picture();
        picture.setPath(filePath);
        return pictureMapper.insPic(picture);
    }

    public int delPic(int id) {
        return pictureMapper.delPic(id);
    }
}
