package mk.ukim.finki.hci.coinsmart.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    @ManyToMany
    private List<Response> responses;
    @OneToOne
    private Response correctAnswer;

    public Question() {
    }

    public Question(String question, List<Response> responses, Response correctAnswer) {
        this.question = question;
        this.responses = responses;
        this.correctAnswer = correctAnswer;
    }
}
