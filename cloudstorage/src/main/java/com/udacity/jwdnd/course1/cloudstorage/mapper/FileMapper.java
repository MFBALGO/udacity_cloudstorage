package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Select("SELECT * FROM FILES WHERE fileId = #{fileId}")
    File getFileId(Integer fileId);

    @Select("SELECT * FROM FILES WHERE filename = #{filename}")
    File getFilename(String filename);

    @Select("SELECT * FROM FILES WHERE contenttype = #{contenttype}")
    File getContenttype(String contenttype);

    @Select("SELECT * FROM FILES WHERE filesize = #{filesize}")
    File getFilesize(String filesize);

    @Select("SELECT * FROM FILES WHERE userid = #{userid}")
    List<File> getUserid(Integer userid);

    @Insert("INSERT INTO FILES (fileId, filename, contenttype, filesize, userid, filedata) VALUES(#{fileId}, #{filename}, #{contenttype}, #{filesize}, #{userid}, #{filedata})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insert(File file);

    @Delete("DELETE FROM Files WHERE fileId = #{fileId}")
    Integer delete(Integer fileId);

}
