package com.project.TimeNote.service;

import com.project.TimeNote.domain.subject.Days;
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

    @Transactional(readOnly = true)
    public List<SubjectEntity> 월요일가져오기(){

        return subjectRepository.findByDay(Days.월);
    }

    @Transactional(readOnly = true)
    public List<SubjectEntity> 화요일가져오기(){

        return subjectRepository.findByDay(Days.화);
    }

    @Transactional(readOnly = true)
    public List<SubjectEntity> 수요일가져오기(){

        return subjectRepository.findByDay(Days.수);
    }


    @Transactional(readOnly = true)
    public List<SubjectEntity> 목요일가져오기(){

        return subjectRepository.findByDay(Days.목);
    }

    @Transactional(readOnly = true)
    public List<SubjectEntity> 금요일가져오기(){

        return subjectRepository.findByDay(Days.금);
    }


}
