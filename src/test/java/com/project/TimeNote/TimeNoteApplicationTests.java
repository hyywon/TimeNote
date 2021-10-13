package com.project.TimeNote;

import com.project.TimeNote.domain.note.NoteEntity;
import com.project.TimeNote.domain.note.NoteRepository;
import com.project.TimeNote.domain.subject.Days;
import com.project.TimeNote.domain.subject.SubjectEntity;
import com.project.TimeNote.domain.subject.SubjectRepository;
import com.project.TimeNote.domain.user.UserEntity;
import com.project.TimeNote.domain.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Time;

@SpringBootTest
class TimeNoteApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	NoteRepository noteRepository;

	@Autowired
	SubjectRepository subjectRepository;

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/timenotes?serverTimezone=UTC&characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)){
			System.out.println(connection);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	public void 회원가입(){
		UserEntity user = new UserEntity("test", "test", "test", "school");

		userRepository.save(user);

		System.out.println(user.getSchool());
	}

	@Test
	@Transactional
	public void 노트작성(){
		NoteEntity note = new NoteEntity("test","test");

		noteRepository.save(note);

		System.out.println(note.getTitle());
	}

	@Test
	@Transactional
	public void 과목생성() { //Time.valueOf("10:00:00")
		SubjectEntity subject = new SubjectEntity("sub",1234, "test", Days.Mon, "10:00" , "12:00");

		subjectRepository.save(subject);
		System.out.println(subject.getName());
	}

}
