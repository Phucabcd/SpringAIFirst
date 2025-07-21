package ntp.springaifirst.repo;

import ntp.springaifirst.entity.MessageMemory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageMemoryRepo extends JpaRepository<MessageMemory, String> {
//    @Query(value = "SELECT * from spring_ai_chat_memory where conversation_id = :id", nativeQuery = true)
    @Query("SELECT m FROM MessageMemory m WHERE m.id = :id")
    List<MessageMemory> findMemoryId(@Param("id") String id);
}
