package com.project.TimeNote.service;

import com.project.TimeNote.domain.subject.SubjectEntity;
import com.project.TimeNote.domain.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Transactional
    public void 과목추가(SubjectEntity subject) {

        subjectRepository.save(subject);
    }

    @Transactional(readOnly = true)
    public List<SubjectEntity> 가져오기(){

        return subjectRepository.findAll();
    }
}
