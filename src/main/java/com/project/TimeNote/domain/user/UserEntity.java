package com.project.TimeNote.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "username", length = 500)
    String username;

    @Column(name = "email", length = 500)
    String email;

    @Column(name = "password",length = 1000)
    String password;

    @Column(name = "school", length = 500)
    String school;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSchool() {
        return school;
    }

    public UserEntity(String email, String username, String password, String school){
        this.email = email;
        this.username = username;
        this.password = password;
        this.school = school;
    }
}
