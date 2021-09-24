package com.igt.reactivedemo.reactivestackserverdemo.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public abstract class RandomDateProvider {

    public static LocalDateTime provideRandomDate() {
        long minDay = LocalDate.now().toEpochDay();
        long maxDay = LocalDate.of(2023, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate.atStartOfDay();
    }
}
