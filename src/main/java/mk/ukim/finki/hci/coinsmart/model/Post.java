package mk.ukim.finki.hci.coinsmart.model;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String content;
    private Date date;

    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(String content, User user) {
        this.content = content;
        SimpleDateFormat formatter= new SimpleDateFormat("MMM d yyyy z");
        this.date = new Date(System.currentTimeMillis());
        this.user = user;
    }
}
