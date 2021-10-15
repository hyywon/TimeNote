package com.project.TimeNote.domain.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Integer> {

    @Modifying
    @Query(value="INSERT INTO note(title, content, subject_id) VALUES(?1,?2,?3)", nativeQuery = true)
    int noteSave(String title, String content,Integer subject_id);
}

