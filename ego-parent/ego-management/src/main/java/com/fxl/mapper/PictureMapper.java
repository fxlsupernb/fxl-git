package com.fxl.mapper;

import com.fxl.pojo.Picture;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author FanXingLong
 * @date 2020-06-17
 */
public interface PictureMapper {

    @Select("select * from picture")
    List<Picture> selAll();

    int insPic(Picture picture);

    @Delete("delete from picture where id=#{id}")
    int delPic(int id);
}
