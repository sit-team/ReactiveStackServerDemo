package com.igt.reactivedemo.reactivestackserverdemo.service;

import com.igt.reactivedemo.reactivestackserverdemo.domain.Movie;
import com.igt.reactivedemo.reactivestackserverdemo.domain.MovieEvent;
import com.igt.reactivedemo.reactivestackserverdemo.domain.MovieRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static com.igt.reactivedemo.reactivestackserverdemo.util.RandomDateProvider.provideRandomDate;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Flux<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }

    public Mono<Movie> getMovieById(String id) {
        return this.movieRepository.findById(id);
    }

    public Flux<MovieEvent> getEventsForMovie(String id) {
        return Flux.<MovieEvent>generate(sink -> sink.next(
                        new MovieEvent(id, provideRandomDate())))
                .delayElements(Duration.ofSeconds(1))
                .log();
    }
}
