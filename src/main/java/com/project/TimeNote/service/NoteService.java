package com.project.TimeNote.service;

import com.project.TimeNote.domain.note.NoteEntity;
import com.project.TimeNote.domain.note.NoteRepository;
import com.project.TimeNote.domain.subject.SubjectEntity;
import com.project.TimeNote.domain.subject.SubjectRepository;
import com.project.TimeNote.domain.user.UserEntity;
import com.project.TimeNote.domain.user.UserRepository;
import com.project.TimeNote.dto.ResponseDto;
import com.project.TimeNote.dto.note.NoteSaveDto;
import com.project.TimeNote.dto.note.NoteUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
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

    @Autowired
    private SubjectRepository subjectRepository;


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
    public void 작성하기(NoteSaveDto noteSaveDto){
        System.out.println(noteSaveDto.getUser_id());
        UserEntity user = userRepository.findByUsername(noteSaveDto.getUser_id()).orElseGet(()->{
            return null;
        });
        noteRepository.noteSave(noteSaveDto.getTitle(), noteSaveDto.getContent(), noteSaveDto.getSubject_id(), user.getId(), noteSaveDto.getCreate_at());

    }

    @Transactional
    public void 삭제하기(Integer id){
        userRepository.deleteById(id);

    }

    @Transactional
    public void 수정하기(Integer id, NoteUpdateDto note){
        NoteEntity update = noteRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글 업데이트 실패");
        });

        SubjectEntity sub = subjectRepository.findById(note.getSubject_id()).orElseGet(()->{
            return null;
        });

        update.edit(note.getTitle(), note.getContent(), sub);
    }
}
