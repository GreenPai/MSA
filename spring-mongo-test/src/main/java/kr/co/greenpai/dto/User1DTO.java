package kr.co.greenpai.dto;

import kr.co.greenpai.document.User1Document;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User1DTO {

    private String uid;
    private String name;
    private int age;
    private String addr;

    public User1Document toDocument(){
        return User1Document.builder()
                .uid(uid)
                .name(name)
                .age(age)
                .addr(addr)
                .build();
    }

}
