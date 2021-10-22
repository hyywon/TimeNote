package com.project.TimeNote.controller;

import com.project.TimeNote.domain.note.NoteEntity;
import com.project.TimeNote.dto.ResponseDto;
import com.project.TimeNote.dto.note.NoteSaveDto;
import com.project.TimeNote.dto.note.NoteUpdateDto;
import com.project.TimeNote.service.NoteService;
import com.project.TimeNote.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class NoteApiController {

    @Autowired
    NoteService noteService;

    @PostMapping("/note/add")
    public ResponseDto<Integer> addNote(@RequestBody NoteSaveDto note){
        System.out.println(note.getTitle() + note.getContent() + note.getSubject_id() + note.getUser_id());
        note.setCreate_at(LocalDateTime.now());
        noteService.작성하기(note);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/note/delete/{id}")
    public ResponseDto<Integer> noteDelete(@PathVariable String id){
        Integer ID = Integer.parseInt(id);
        noteService.삭제하기(ID);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);

    }

    @PutMapping("/note/update/{id}")
    public ResponseDto<Integer> noteUpdate(@PathVariable Integer id, @RequestBody NoteUpdateDto note){
        noteService.수정하기(id,note);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
