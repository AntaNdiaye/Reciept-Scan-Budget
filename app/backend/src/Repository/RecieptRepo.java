package Repository;

import Models.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecieptRepo extends JpaRepository<Receipt, Long> {
}