package com.project.TimeNote.controller;

import com.project.TimeNote.domain.subject.SubjectEntity;
import com.project.TimeNote.dto.ResponseDto;
import com.project.TimeNote.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SubjectApiController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/subject/add")
    public ResponseDto<Integer> join(@RequestBody SubjectEntity subject){
        System.out.println(subject.getName() + subject.getNo() + subject.getProfessor() + subject.getStart_class() + "-" + subject.getFinish_class());
        System.out.println("Subject Add API");
        subjectService.과목추가(subject);

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
}
