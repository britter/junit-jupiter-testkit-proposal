package com.github.britter.junit.jupiter.testkit;

public interface SkippedEvent extends ExecutionEvent {

    String getReason();
}
