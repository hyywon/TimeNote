package com.project.TimeNote.service;

import com.project.TimeNote.domain.note.NoteEntity;
import com.project.TimeNote.domain.note.NoteRepository;
import com.project.TimeNote.domain.user.UserEntity;
import com.project.TimeNote.domain.user.UserRepository;
import com.project.TimeNote.dto.ResponseDto;
import com.project.TimeNote.dto.note.NoteSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<NoteEntity> 가져오기(){

        return noteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<NoteEntity> 과목별가져오기(Integer id){

        return noteRepository.findBySubjectId(id);
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
        System.out.println(noteSaveDto.getUser_id());
        UserEntity user = userRepository.findByUsername(noteSaveDto.getUser_id()).orElseGet(()->{
            return null;
        });
        noteRepository.noteSave(noteSaveDto.getTitle(), noteSaveDto.getContent(), noteSaveDto.getSubject_id(), user.getId());

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
