package com.github.britter.junit.jupiter.testkit;

import java.util.Optional;
import org.junit.platform.engine.TestDescriptor;

public interface ExecutionEvent {

    enum Type {
        DYNAMIC_TEST_REGISTERED, SKIPPED, STARTED, FINISHED, REPORTING_ENTRY_PUBLISHED
    }

    ExecutionEvent.Type getType();

    TestDescriptor getTestDescriptor();

    <T> Optional<T> getPayload(Class<T> payloadClass);
}
