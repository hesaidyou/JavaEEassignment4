package edu.bjtu.reative.services;

import org.springframework.stereotype.Service;

import edu.bjtu.reative.models.Course;
import edu.bjtu.reative.repositories.CourseRepository;
import edu.bjtu.reative.services.CourseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseServiceImpl implements CourseService{
	private CourseRepository cr;
	public CourseServiceImpl(CourseRepository cr) {
		this.cr = cr;
	}
	
    @Override
    public Mono<Course> findByCourseid(String id) {
        return cr.findById(id);
    }
    @Override
    public Flux<Course> findAll() {
        return cr.findAll();
    }
    @Override
    public Mono<Course> save(Course course) {
        return cr.save(course);
    }
    @Override
    public Mono<Void> deleteByCourseid(String id) {
        return cr.deleteById(id);
    }
}
