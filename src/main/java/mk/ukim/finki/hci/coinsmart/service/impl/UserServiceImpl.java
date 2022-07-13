package mk.ukim.finki.hci.coinsmart.service.impl;

import mk.ukim.finki.hci.coinsmart.model.Course;
import mk.ukim.finki.hci.coinsmart.model.User;
import mk.ukim.finki.hci.coinsmart.model.enums.Role;
import mk.ukim.finki.hci.coinsmart.model.exceptions.InvalidUserException;
import mk.ukim.finki.hci.coinsmart.model.exceptions.InvalidUsernameOrPasswordException;
import mk.ukim.finki.hci.coinsmart.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.hci.coinsmart.model.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.hci.coinsmart.repository.UserRepository;
import mk.ukim.finki.hci.coinsmart.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> register(String username, String email, String password, String repeatPassword, String fullName, Role role) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidUsernameOrPasswordException();
        }

        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }

        if (this.userRepository.findByUsername(username).isPresent()) {
            throw new UsernameAlreadyExistsException(username);
        }

        User user = new User(username, passwordEncoder.encode(password), fullName, email, role);
        return Optional.of(this.userRepository.save(user));
    }

    @Override
    public Optional<User> login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidUsernameOrPasswordException();
        }
        return this.userRepository.findByUsernameAndPassword(username, password).or(()->Optional.of(new User()));
    }

    @Override
    public Optional<Course> addCompletedCourse(User user, Course course) {
        List<Course> completedCourses = user.getCompletedCourses();
        completedCourses.add(course);

        user.setCompletedCourses(completedCourses);
        this.userRepository.save(user);
        return Optional.of(course);
    }

    @Override
    public User markCompletedQuiz(User user) {
        user.setCompletedQuiz(true);
        this.userRepository.save(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public User update(Long userId, String username, String fullName, String email) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new InvalidUserException(userId));

        user.setUsername(username);
        user.setEmail(email);
        user.setFullName(fullName);
        return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
