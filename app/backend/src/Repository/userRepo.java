package Repository;

import Models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface userRepo extends JpaRepository<User, Long>{
}