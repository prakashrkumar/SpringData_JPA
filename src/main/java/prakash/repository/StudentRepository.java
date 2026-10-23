package prakash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prakash.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByName(String name);
}
