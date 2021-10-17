package com.project.TimeNote.controller;

import com.project.TimeNote.domain.note.NoteEntity;
import com.project.TimeNote.domain.note.NoteRepository;
import com.project.TimeNote.service.NoteService;
import com.project.TimeNote.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping({"","/"})
    public String index(Model model){
        model.addAttribute("subjects", subjectService.가져오기());
        model.addAttribute("notes", noteService.가져오기());
        return "index";
    }


    @GetMapping("/note")
    public String Note(Model model) {
        model.addAttribute("subjects", subjectService.가져오기());

        return "note";
    }

    @GetMapping("/detail")
    public String DetailNote(Model model, @RequestParam String id){
        Integer ID = Integer.parseInt(id);
        model.addAttribute("note", noteService.상세보기(ID));
        return "detail";
    }

    @GetMapping("/time")
    public String TimeTable(){

        return "timetable";
    }

    @GetMapping("/addTime")
    public String AddTime(){

        return "addTime";
    }

}