package com.project.TimeNote.domain.note;

import com.project.TimeNote.domain.subject.SubjectEntity;
import com.project.TimeNote.domain.user.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "NOTE")
@NoArgsConstructor
@Data
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Integer id;

    @Column(name = "title", length = 100)
    String title;

    @Column(name = "content", length = 500)
    String content;

    @CreationTimestamp //시간 자동 입력
    private Timestamp create_at;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;


}
