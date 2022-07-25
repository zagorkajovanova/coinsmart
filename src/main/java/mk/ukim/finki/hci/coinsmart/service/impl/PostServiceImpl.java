package mk.ukim.finki.hci.coinsmart.service.impl;

import mk.ukim.finki.hci.coinsmart.model.Post;
import mk.ukim.finki.hci.coinsmart.model.User;
import mk.ukim.finki.hci.coinsmart.repository.PostRepository;
import mk.ukim.finki.hci.coinsmart.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post addNewPost(User user, String content) {
        Post post = new Post(content, user);
        this.postRepository.save(post);
        return post;
    }

    @Override
    public List<Post> findAll() {
        return this.postRepository.findAll();
    }
}
