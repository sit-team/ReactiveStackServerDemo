package com.igt.reactivedemo.reactivestackserverdemo.util;

import com.igt.reactivedemo.reactivestackserverdemo.domain.Movie;
import com.igt.reactivedemo.reactivestackserverdemo.domain.MovieRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Component
public class DataLoader {

    private final MovieRepository movieRepository;

    public DataLoader(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostConstruct
    public void loadData() {
        movieRepository.deleteAll()
                .thenMany(Flux.just("Back to the future", "Back to the future II")
                        .map(Movie::new)
                        .flatMap(movieRepository::save))
                .subscribe();
    }
}
