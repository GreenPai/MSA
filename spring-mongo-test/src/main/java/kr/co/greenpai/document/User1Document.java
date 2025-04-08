package kr.co.greenpai.document;

import kr.co.greenpai.dto.User1DTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(value="user1")
public class User1Document {

    @Id
    private String _id;
    private String uid;
    private String name;
    private int age;
    private String addr;

    public User1DTO toDTO(){
        return User1DTO.builder()
                .uid(uid)
                .name(name)
                .age(age)
                .addr(addr)
                .build();
    }
}
