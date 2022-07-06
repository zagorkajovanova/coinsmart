package mk.ukim.finki.hci.coinsmart.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseName;

    public Course() {
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }
}
