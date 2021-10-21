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
public class SubjectController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping({"/sub"})
    public String index(Model model, Principal principal, @RequestParam String id){
        Integer ID = Integer.parseInt(id);
        model.addAttribute("subjects", subjectService.가져오기());
        model.addAttribute("notes", noteService.과목별가져오기(ID));
        model.addAttribute("user", principal);
        return "index";
    }

    @GetMapping("/time")
    public String TimeTable(Model model, Principal principal){
        model.addAttribute("mon", subjectService.월요일가져오기());
        model.addAttribute("tue", subjectService.화요일가져오기());
        model.addAttribute("wed", subjectService.수요일가져오기());
        model.addAttribute("thu", subjectService.목요일가져오기());
        model.addAttribute("fri", subjectService.금요일가져오기());
        model.addAttribute("user", principal);

        return "timetable";
    }

    @GetMapping("/addTime")
    public String AddTime(){

        return "addTime";
    }

}