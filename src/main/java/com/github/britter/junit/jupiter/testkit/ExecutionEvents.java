package com.github.britter.junit.jupiter.testkit;

import java.util.List;
import java.util.stream.Stream;

public interface ExecutionEvents {

    TestExecutionStatistics getStatistics();

    List<ExecutionEvent> asList();

    Stream<ExecutionEvent> asStream();

}
