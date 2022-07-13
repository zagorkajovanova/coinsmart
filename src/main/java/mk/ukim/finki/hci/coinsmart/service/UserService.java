package mk.ukim.finki.hci.coinsmart.service;

import mk.ukim.finki.hci.coinsmart.model.Course;
import mk.ukim.finki.hci.coinsmart.model.User;
import mk.ukim.finki.hci.coinsmart.model.enums.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> register(String username, String email, String password, String repeatPassword, String fullName, Role role);
    Optional<User> login(String username, String password);
    Optional<Course> addCompletedCourse(User user, Course course);
    User markCompletedQuiz(User user);
    User findByUsername(String username);
    User update(Long userId, String username, String fullName, String email);
}
