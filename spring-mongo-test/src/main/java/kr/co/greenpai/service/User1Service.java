package kr.co.greenpai.service;

import kr.co.greenpai.document.User1Document;
import kr.co.greenpai.dto.User1DTO;
import kr.co.greenpai.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User1Service {

    private final User1Repository user1Repository;

    public void save(User1DTO user1DTO) {
        User1Document user1Document = user1DTO.toDocument();
        user1Repository.save(user1Document);
    }

    public List<User1DTO> findAll(){
        List<User1Document> user1List = user1Repository.findAll();

        List<User1DTO> user1DTOList = user1List.stream()
                                        .map((document)->{
                                            User1DTO dto = document.toDTO();
                                            return dto;
                                        }).toList();
        return user1DTOList;
    }
    public User1DTO findById(String uid){
        Optional<User1Document> user1Document = user1Repository.findByUid(uid);

        if(user1Document.isPresent()){
            User1DTO dto = user1Document.get().toDTO();
            return dto;
        }
        return null;
    }

    public void modify(User1DTO user1DTO){

        String uid = user1DTO.getUid();

        Optional<User1Document> optUser1 = user1Repository.findByUid(uid);

        if(optUser1.isPresent()){
            
            // 수정
            User1Document user1Document = optUser1.get();
            User1Document modifiedUser1 = user1DTO.toDocument();
            modifiedUser1.set_id(user1Document.get_id());

            user1Repository.save(modifiedUser1);
        }

    }

    public void delete(String uid){
        user1Repository.deleteByUid(uid);
    }

}
