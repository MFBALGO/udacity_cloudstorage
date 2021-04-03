package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NoteService {

    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating NoteService bean");
    }

    public Note findNote(Integer noteId){
        return noteMapper.findNote(noteId);
    }

    public List<Note> getNotesForUser(int userId){
        return noteMapper.getNotesByUserId(userId);
    }

    public Integer addNote(Note note){
        if(note.getNoteId() == null){
            Note newNote = new Note(note.getNoteTitle(), note.getNoteDescription(), note.getUserId());
            return noteMapper.addNote(newNote);
        }else{
            return noteMapper.updateNote(note);
        }
    }

}
