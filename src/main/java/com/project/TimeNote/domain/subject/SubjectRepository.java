package com.project.TimeNote.domain.subject;

import com.project.TimeNote.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer> {

    List<SubjectEntity> findByDay(Days day);

}
