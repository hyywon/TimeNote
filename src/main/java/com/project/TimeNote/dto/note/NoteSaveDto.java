package com.project.TimeNote.dto.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteSaveDto {
    private String title;
    private String content;
    private Integer subject_id;

}

