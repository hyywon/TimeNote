package com.project.TimeNote.domain.subject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.TimeNote.domain.note.NoteEntity;
import com.project.TimeNote.domain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "day")
    private Days day;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subject", cascade = CascadeType.REMOVE) // 연관관계의 주인 X
    @JsonIgnoreProperties({"note","user"})
    private List<NoteEntity> notes;

    @JsonFormat(pattern="HH:MM")
    @Column(name = "start_class")
    String start_class;

    @JsonFormat(pattern="HH:MM")
    @Column(name = "finish_class")
    String finish_class;


    public SubjectEntity(String name, Integer no, String professor, Days day, String start, String finish){
        this.name = name;
        this.no = no;
        this.day = day;
        this.professor = professor;
        this.start_class = start;
        this.finish_class = finish;
    }

    public String getDay() {
        return day.toString();
    }

    public String getStart_class() {
        return start_class.substring(0,5);
    }

    public String getFinish_class() {
        return finish_class.substring(0,5);
    }
}
