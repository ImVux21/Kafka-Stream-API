package com.practices.kafkastreamapi.domain;

import java.time.LocalDateTime;

public record Greeting(
        String message,
        LocalDateTime timeStamp
) {
}
