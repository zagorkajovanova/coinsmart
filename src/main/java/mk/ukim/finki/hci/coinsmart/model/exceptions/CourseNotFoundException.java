package mk.ukim.finki.hci.coinsmart.model.exceptions;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException() {
        super("Course not found!");
    }

}
