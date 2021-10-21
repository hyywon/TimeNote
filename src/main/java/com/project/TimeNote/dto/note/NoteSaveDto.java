package com.project.TimeNote.dto.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteSaveDto {
    private String title;
    private String content;
    private Integer subject_id;
    private String user_id;
    private LocalDateTime create_at;

}

