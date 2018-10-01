package com.github.britter.junit.jupiter.testkit;

import org.junit.platform.engine.TestExecutionResult;

public interface FinishedEvent extends ExecutionEvent {

    TestExecutionResult getResult();
}
