package com.example.app.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "app")
public class App extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public App() {} //entity는 기본 생성자를 가져야됨

    public App(String title, String contents) { // id는 자동 생성, member는 참조하는 값이니깐
        this.title = title;
        this.contents = contents;
    }

    public void setUser(User user) {
        this.user = user;
    } // 작성자 추가

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
