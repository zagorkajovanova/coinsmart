package mk.ukim.finki.hci.coinsmart.config;

import lombok.Getter;
import mk.ukim.finki.hci.coinsmart.model.Course;
import mk.ukim.finki.hci.coinsmart.model.User;
import mk.ukim.finki.hci.coinsmart.model.enums.Role;
import mk.ukim.finki.hci.coinsmart.repository.CourseRepository;
import mk.ukim.finki.hci.coinsmart.repository.UserRepository;
import mk.ukim.finki.hci.coinsmart.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class DataInitializer {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final UserService userService;

    public DataInitializer(UserRepository userRepository, CourseRepository courseRepository, UserService userService) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.userService = userService;
    }

    @PostConstruct
    public void init(){
        Course course1 = new Course("What is Cryptocurrency?");
        Course course2 = new Course("What is Blockchain?");
        Course course3 = new Course("What is Ethereum?");
        Course course4 = new Course("What is Bitcoin?");
        Course course5 = new Course("Bitcoin, scarcity & trust in money");
        Course course6 = new Course("Building on top of Bitcoin");

        this.courseRepository.save(course1);
        this.courseRepository.save(course2);
        this.courseRepository.save(course3);
        this.courseRepository.save(course4);
        this.courseRepository.save(course5);
        this.courseRepository.save(course6);

        User user = userService.register("user", "user@test.com", "user", "user", "User User", Role.ROLE_USER).get();
        this.userRepository.save(user);

    }
}
