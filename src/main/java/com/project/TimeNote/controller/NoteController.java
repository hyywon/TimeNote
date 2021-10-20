package com.project.TimeNote.controller;

import com.project.TimeNote.service.NoteService;
import com.project.TimeNote.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping({"","/"})
    public String index(Model model, Principal principal){
        model.addAttribute("subjects", subjectService.가져오기());
        model.addAttribute("notes", noteService.가져오기());
        model.addAttribute("user", principal);
        return "index";
    }


    @GetMapping("/note")
    public String Note(Model model, Principal principal) {
        model.addAttribute("subjects", subjectService.가져오기());
        model.addAttribute("user", principal);

        return "note";
    }

    @GetMapping("/detail")
    public String DetailNote(Model model, @RequestParam String id){
        Integer ID = Integer.parseInt(id);
        model.addAttribute("note", noteService.상세보기(ID));
        return "detail";
    }


}