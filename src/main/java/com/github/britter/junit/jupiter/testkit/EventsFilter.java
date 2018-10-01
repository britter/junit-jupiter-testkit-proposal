package com.github.britter.junit.jupiter.testkit;

import org.junit.platform.engine.TestExecutionResult;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventsFilter {

    ExecutionEvent.Type[] value() default {
            ExecutionEvent.Type.DYNAMIC_TEST_REGISTERED,
            ExecutionEvent.Type.SKIPPED,
            ExecutionEvent.Type.STARTED,
            ExecutionEvent.Type.FINISHED,
            ExecutionEvent.Type.REPORTING_ENTRY_PUBLISHED
    };

    ExecutedElementType[] type() default {ExecutedElementType.TEST, ExecutedElementType.CONTAINER};

    TestExecutionResult.Status[] status() default {
            TestExecutionResult.Status.ABORTED,
            TestExecutionResult.Status.FAILED,
            TestExecutionResult.Status.SUCCESSFUL
    };
}
