package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileMapper {

    @Select("SELECT * FROM FILE WHERE fileId = #{fileId}")
    File getFileId(Integer fileId);

    @Select("SELECT * FROM FILE WHERE filename = #{filename}")
    File getFilename(String filename);

    @Select("SELECT * FROM FILE WHERE contenttype = #{contenttype}")
    File getContenttype(String contenttype);

    @Select("SELECT * FROM FILE WHERE filesize = #{filesize}")
    File getFilesize(String filesize);

    @Select("SELECT * FROM FILE WHERE userid = #{userid}")
    File getUserid(Integer userid);

    @Insert("INSERT INTO FILE (fileId, filename, contenttype, filesize, userid) VALUES(#{fileId}, #{filename}, #{contenttype}, #{filesize}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insert(File file);

}
