package mk.ukim.finki.hci.coinsmart.service;

import mk.ukim.finki.hci.coinsmart.model.Post;
import mk.ukim.finki.hci.coinsmart.model.User;

import java.util.List;

public interface PostService {
    Post addNewPost(User user, String content);
    List<Post> findAll();
}
