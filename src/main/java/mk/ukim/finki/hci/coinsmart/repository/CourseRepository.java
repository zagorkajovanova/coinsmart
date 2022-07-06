package mk.ukim.finki.hci.coinsmart.repository;

import mk.ukim.finki.hci.coinsmart.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
