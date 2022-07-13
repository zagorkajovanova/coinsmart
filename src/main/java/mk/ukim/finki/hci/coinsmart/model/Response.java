package mk.ukim.finki.hci.coinsmart.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String responseText;

    public Response() {
    }

    public Response(String responseText) {
        this.responseText = responseText;
    }
}
