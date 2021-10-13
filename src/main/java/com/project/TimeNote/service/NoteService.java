package com.project.TimeNote.service;

import com.project.TimeNote.domain.note.NoteEntity;
import com.project.TimeNote.domain.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Transactional(readOnly = true)
    public List<NoteEntity> 가져오기(){

        return noteRepository.findAll();
    }

}
