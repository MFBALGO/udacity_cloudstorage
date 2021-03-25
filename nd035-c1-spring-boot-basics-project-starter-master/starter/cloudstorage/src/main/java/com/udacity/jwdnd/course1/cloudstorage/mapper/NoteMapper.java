package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface NoteMapper {

    @Select("SELECT * FROM NOTES WHERE noteid = #{noteid}")
    Note getNoteId(String noteid);

    @Select("SELECT * FROM NOTES WHERE notetitle = #{notetitle}")
    Note getNoteTitle(String notetitle);

    @Select("SELECT * FROM NOTES WHERE notedescription = #{notedescription}")
    Note getNotedescription(String notedescription);

    @Select("SELECT * FROM NOTES WHERE userid = #{userid}")
    Note getUserid(String userid);

    @Insert("INSERT INTO NOTES (noteid, notetitle, notedescription, userid) VALUES(#{noteid}, #{notetitle}, #{notedescription}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    int insert(Note note);

}
