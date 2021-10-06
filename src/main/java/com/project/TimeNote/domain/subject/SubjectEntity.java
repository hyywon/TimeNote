package com.project.TimeNote.domain.subject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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

    public SubjectEntity(String name, Integer no){
        this.name = name;
        this.no = no;
    }

}
