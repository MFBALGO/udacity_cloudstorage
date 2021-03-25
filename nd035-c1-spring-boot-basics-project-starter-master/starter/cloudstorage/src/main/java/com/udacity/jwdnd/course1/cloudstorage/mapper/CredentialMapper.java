package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface CredentialMapper {

    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialid}")
    File getCredentialid(Integer credentialid);

    @Select("SELECT * FROM CREDENTIALS WHERE url = #{url}")
    File getUrl(String url);

    @Select("SELECT * FROM CREDENTIALS WHERE username = #{username}")
    File getContenttype(String contenttype);

    @Select("SELECT * FROM CREDENTIALS WHERE password = #{password}")
    File getPassword(String password);

    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userid}")
    File getUserid(String userid);

    @Insert("INSERT INTO CREDENTIALS (credentialid, url, username, password, userid) VALUES(#{credentialid}, #{url}, #{username}, #{password}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialid")
    int insert(Credential credential);

}
