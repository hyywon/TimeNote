package com.project.TimeNote.dto.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteUpdateDto {
    private String title;
    private String content;
    private Integer subject_id;

}

