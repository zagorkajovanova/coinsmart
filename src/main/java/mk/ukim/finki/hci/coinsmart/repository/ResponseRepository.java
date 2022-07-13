package mk.ukim.finki.hci.coinsmart.repository;

import mk.ukim.finki.hci.coinsmart.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
}
