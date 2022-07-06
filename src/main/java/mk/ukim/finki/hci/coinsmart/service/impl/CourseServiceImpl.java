package mk.ukim.finki.hci.coinsmart.service.impl;

import mk.ukim.finki.hci.coinsmart.model.Course;
import mk.ukim.finki.hci.coinsmart.model.exceptions.CourseNotFoundException;
import mk.ukim.finki.hci.coinsmart.repository.CourseRepository;
import mk.ukim.finki.hci.coinsmart.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
    }
}
