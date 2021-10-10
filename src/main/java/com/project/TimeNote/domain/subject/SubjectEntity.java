package com.project.TimeNote.domain.subject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "SUBJECT")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer id;

    @Column(name = "name", length = 100)
    String name;

    @Column(name = "no")
    Integer no;

    @Column(name = "professor")
    String professor;

    @Column(name = "start_class")
    Time start_class;

    @Column(name = "finish_class")
    Time finish_class;


    public SubjectEntity(String name, Integer no, String professor, Time start, Time finish){
        this.name = name;
        this.no = no;
        this.professor = professor;
        this.start_class = start;
        this.finish_class = finish;
    }

}
