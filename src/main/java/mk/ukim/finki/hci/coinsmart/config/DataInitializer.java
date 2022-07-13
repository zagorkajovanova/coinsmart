package mk.ukim.finki.hci.coinsmart.config;

import lombok.Getter;
import mk.ukim.finki.hci.coinsmart.model.Course;
import mk.ukim.finki.hci.coinsmart.model.Question;
import mk.ukim.finki.hci.coinsmart.model.Response;
import mk.ukim.finki.hci.coinsmart.model.User;
import mk.ukim.finki.hci.coinsmart.model.enums.Role;
import mk.ukim.finki.hci.coinsmart.repository.CourseRepository;
import mk.ukim.finki.hci.coinsmart.repository.QuestionRepository;
import mk.ukim.finki.hci.coinsmart.repository.ResponseRepository;
import mk.ukim.finki.hci.coinsmart.repository.UserRepository;
import mk.ukim.finki.hci.coinsmart.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Getter
public class DataInitializer {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final UserService userService;
    private final ResponseRepository responseRepository;
    private final QuestionRepository questionRepository;

    public DataInitializer(UserRepository userRepository, CourseRepository courseRepository, UserService userService, ResponseRepository responseRepository, QuestionRepository questionRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.userService = userService;
        this.responseRepository = responseRepository;
        this.questionRepository = questionRepository;
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

        Response response1 = new Response("Encrypted currency of a certain state");
        Response response2 = new Response("A type of digital currency");
        Response response3 = new Response("Hackers' secret money");
        this.responseRepository.save(response1);
        this.responseRepository.save(response2);
        this.responseRepository.save(response3);
        List<Response> responseList = new ArrayList<>(Arrays.asList(response1,response2,response3));
        Question question1 = new Question("What is cryptocurrency?", responseList, response2);
        this.questionRepository.save(question1);

        Response response4 = new Response("Blockchain");
        Response response5 = new Response("Photometrics");
        Response response6 = new Response("Cryptanalysis");
        this.responseRepository.save(response4);
        this.responseRepository.save(response5);
        this.responseRepository.save(response6);
        responseList = new ArrayList<>(Arrays.asList(response4,response5,response6));
        Question question2 = new Question("What technology is the cryptocurrency based on?", responseList, response4);
        this.questionRepository.save(question2);

        Response response7 = new Response("Cryptocurrency value data");
        Response response8 = new Response("A secret database by which the owners of the cryptocurrency manage it");
        Response response9 = new Response("A sequential chain of blocks containing information");
        this.responseRepository.save(response7);
        this.responseRepository.save(response8);
        this.responseRepository.save(response9);
        responseList = new ArrayList<>(Arrays.asList(response7,response8,response9));
        Question question3 = new Question("What is blockchain?", responseList, response9);
        this.questionRepository.save(question3);

        Response response10 = new Response("Makeup");
        Response response11 = new Response("Fabrication");
        Response response12 = new Response("Mining");
        this.responseRepository.save(response10);
        this.responseRepository.save(response11);
        this.responseRepository.save(response12);
        responseList = new ArrayList<>(Arrays.asList(response10,response11,response12));
        Question question4 = new Question("What is the production of cryptocurrency called?", responseList, response12);
        this.questionRepository.save(question4);

        Response response13 = new Response("John Smith");
        Response response14 = new Response("Satoshi Nakamoto");
        Response response15 = new Response("Xiao Huawei");
        this.responseRepository.save(response13);
        this.responseRepository.save(response14);
        this.responseRepository.save(response15);
        responseList = new ArrayList<>(Arrays.asList(response13,response14,response15));
        Question question5 = new Question("Select the pseudonym of the founder of the Bitcoin payment system.", responseList, response14);
        this.questionRepository.save(question5);


    }
}
