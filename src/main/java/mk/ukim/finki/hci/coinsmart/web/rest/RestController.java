package mk.ukim.finki.hci.coinsmart.web.rest;

import mk.ukim.finki.hci.coinsmart.model.Question;
import mk.ukim.finki.hci.coinsmart.repository.QuestionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final QuestionRepository questionRepository;

    public RestController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return this.questionRepository.findAll();
    }
}
