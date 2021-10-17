package com.project.TimeNote.service;

import com.project.TimeNote.domain.note.NoteEntity;
import com.project.TimeNote.domain.note.NoteRepository;
import com.project.TimeNote.dto.ResponseDto;
import com.project.TimeNote.dto.note.NoteSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Transactional(readOnly = true)
    public NoteEntity 상세보기(Integer id){

        NoteEntity note =  noteRepository.findById(id).orElseGet(()->{
            return null;
        });
        return note;
    }

    @Transactional
    public ResponseDto<Integer> 작성하기(NoteSaveDto noteSaveDto){
        noteRepository.noteSave(noteSaveDto.getTitle(), noteSaveDto.getContent(), noteSaveDto.getSubject_id());

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
