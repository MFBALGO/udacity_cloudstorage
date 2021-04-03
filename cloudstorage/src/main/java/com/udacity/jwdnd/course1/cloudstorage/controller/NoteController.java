package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;
    private UserService userService;

    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }
    @PostMapping
    public String addNote(Authentication authentication, Note note, Model model) {
        Integer userId = userService.getUser(authentication.getName()).getUserId();
        note.setUserId(userId);
        try{
            Integer count = this.noteService.addNote(note);
            if(count > 0 ){
                model.addAttribute("success", true);
            }else
                model.addAttribute("error", true);


        }catch (Exception e){
            model.addAttribute("success", false);
            model.addAttribute("errorType", 1);
            model.addAttribute("errorMessage", "Note can't be saved as description exceed 1000 characters");
        }
        return "result";
    }

}
