package ra.edu.ptit_cntt2_it211_session2_ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.edu.ptit_cntt2_it211_session2_ex2.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
