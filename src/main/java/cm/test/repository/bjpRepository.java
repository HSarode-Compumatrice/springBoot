package cm.test.repository;
import cm.test.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bjpRepository extends JpaRepository<bjpTest, Integer>{

}

