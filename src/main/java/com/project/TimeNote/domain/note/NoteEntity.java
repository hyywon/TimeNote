package com.project.TimeNote.domain.note;

import com.project.TimeNote.domain.subject.SubjectEntity;
import com.project.TimeNote.domain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "NOTE")
@AllArgsConstructor
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
    private LocalDateTime create_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    public NoteEntity(String title, String content, SubjectEntity subject){
        this.title = title;
        this.content = content;
        this.subject = subject;
        this.create_at = LocalDateTime.now();
    }

}
