package com.fxl.service.impl;

import com.fxl.mapper.PictureMapper;
import com.fxl.pojo.Picture;
import com.fxl.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author FanXingLong
 * @date 2020-06-17
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${management.url}")
    private String picPath;

    @Resource
    private PictureMapper pictureMapper;

    public List<Picture> selAll() {
        List<Picture> pictures = pictureMapper.selAll();
        for (Picture picture : pictures) {
            picture.setPath(picPath+picture.getPath());
        }
        return pictures;
    }
}
