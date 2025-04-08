package kr.co.greenpai.repository;

import kr.co.greenpai.document.User1Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User1Repository extends MongoRepository<User1Document, String> {
    boolean existsByUid(String uid);

    void deleteByUid(String uid);

    Optional<User1Document> findByUid(String uid);
}
