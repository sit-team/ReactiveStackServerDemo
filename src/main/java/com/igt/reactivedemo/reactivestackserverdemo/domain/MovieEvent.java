package com.igt.reactivedemo.reactivestackserverdemo.domain;

import java.time.LocalDateTime;

public record MovieEvent(String id, LocalDateTime when) {}
