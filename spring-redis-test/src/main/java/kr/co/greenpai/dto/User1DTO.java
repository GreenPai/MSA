package kr.co.greenpai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User1DTO implements Serializable {
    private String uid;
    private String name;
    private int age;
    private String addr;
}
