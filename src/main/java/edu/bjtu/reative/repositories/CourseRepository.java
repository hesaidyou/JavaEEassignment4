package edu.bjtu.reative.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import edu.bjtu.reative.models.Course;

public interface CourseRepository extends ReactiveMongoRepository<Course, String>{

}
