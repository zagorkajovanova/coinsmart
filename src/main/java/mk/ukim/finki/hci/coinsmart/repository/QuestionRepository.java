package mk.ukim.finki.hci.coinsmart.repository;

import mk.ukim.finki.hci.coinsmart.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
