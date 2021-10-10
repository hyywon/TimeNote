package com.project.TimeNote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {

    @GetMapping("/note")
    public String Note() {

        return "note";
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