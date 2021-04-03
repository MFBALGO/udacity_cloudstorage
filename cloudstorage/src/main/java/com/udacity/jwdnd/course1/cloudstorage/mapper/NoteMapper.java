package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM Notes")
    List<Note> getAllNotes();

    @Select("SELECT * FROM Notes where userid = #{userId}")
    List<Note> getNotesByUserId(Integer userId);

    @Select("SELECT * FROM NOTES WHERE noteid = #{noteid}")
    Note findNote(Integer noteid);

    @Select("SELECT * FROM NOTES WHERE notetitle = #{notetitle}")
    Note getNoteTitle(String notetitle);

    @Select("SELECT * FROM NOTES WHERE notedescription = #{notedescription}")
    Note getNotedescription(String notedescription);

    @Select("SELECT * FROM NOTES WHERE userid = #{userid}")
    Note getUserid(String userid);

    @Update("UPDATE notes set notetitle = #{noteTitle}, notedescription = #{noteDescription} where noteid = #{noteId}")
    Integer updateNote(Note note);

    @Insert("INSERT INTO NOTES (noteid, notetitle, notedescription, userid) VALUES(#{noteid}, #{notetitle}, #{notedescription}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    int addNote(Note note);

    @Delete("DELETE FROM Notes WHERE noteid = #{noteId}")
    Integer delete(Integer noteId);
}
