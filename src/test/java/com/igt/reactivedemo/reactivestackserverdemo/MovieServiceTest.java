package com.igt.reactivedemo.reactivestackserverdemo;

import com.igt.reactivedemo.reactivestackserverdemo.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getAllMovies() {
        StepVerifier.withVirtualTime(() -> this.movieService.getAllMovies()
                        .take(10)
                        .collectList())
                .thenAwait(Duration.ofHours(10))
                .consumeNextWith(list -> assertThat(list.size()).isEqualTo(2))
                .verifyComplete();
    }

    @Test
    void get10EventsForMovie() {
        StepVerifier.withVirtualTime(() -> movieService.getEventsForMovie("Back to the future")
                        .take(10)
                        .collectList())
                .thenAwait(Duration.ofHours(10))
                .consumeNextWith(list -> assertThat(list.size()).isEqualTo(10))
                .verifyComplete();
    }
}
