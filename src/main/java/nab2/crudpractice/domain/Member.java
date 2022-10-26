package nab2.crudpractice.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
@GeneratedValue(strategy = GenerationType.IDENTITY)
기본 키 생성을 데이터베이스에 위임
즉, id 값을 null로 하면 DB가 알아서 AUTO_INCREMENT 해준다
 */
@NoArgsConstructor
@Entity
@Getter
// 엔티티
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // 회원번호
    @Column(unique = true)
    private String loginId;
    private String pass;
    private String name;
    private String birth;
    private String email;
    private int age;

    public Member(String loginId, String pass, String name, String birth, String email, int age) {
        this.loginId = loginId;
        this.pass = pass;
        this.name = name;
        this.birth = birth;
        this.email = email;
        this.age = age;
    }

    public void updateInfo(String pass, String name, String birth, String email, int age) {

        this.pass = pass;
        this.name = name;
        this.birth = birth;
        this.email = email;
        this.age = age;

    }
}



