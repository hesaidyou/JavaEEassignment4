package edu.bjtu.reative.controllers;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import edu.bjtu.reative.models.Course;

@Configuration
public class CourseRouter {
	@Bean
    public RouterFunction<ServerResponse> route(CourseHandler handler) {
        return RouterFunctions
                .route(GET("/findcourses").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/findcourse/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findById)
                .andRoute(POST("/savecourse").and(accept(MediaType.APPLICATION_JSON)), handler::save)
                .andRoute(DELETE("/deletecourse/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
    }
}
