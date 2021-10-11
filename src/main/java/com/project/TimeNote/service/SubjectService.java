package com.project.TimeNote.service;

import com.project.TimeNote.domain.subject.SubjectEntity;
import com.project.TimeNote.domain.subject.SubjectRepository;
import com.project.TimeNote.domain.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Transactional
    public void 과목추가(SubjectEntity subject) {

        subjectRepository.save(subject);

    }
}
