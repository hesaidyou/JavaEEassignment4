package edu.bjtu.reative.controllers;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import edu.bjtu.reative.models.Course;
import edu.bjtu.reative.services.CourseService;
import reactor.core.publisher.Mono;

@Component
public class CourseHandler {
	private final CourseService cs;
	public CourseHandler(CourseService cs) {
		this.cs = cs;
	}
	
    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cs.findByCourseid(id), Course.class);
    }
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cs.findAll(), Course.class);
    }
    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Course> course = request.bodyToMono(Course.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(course.flatMap(cs::save), Course.class));
    }
    public Mono<ServerResponse> delete(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cs.deleteByCourseid(id), Void.class);
    }
}
