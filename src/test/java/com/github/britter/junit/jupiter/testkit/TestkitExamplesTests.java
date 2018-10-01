package com.github.britter.junit.jupiter.testkit;

import com.github.britter.junit.jupiter.testkit.TestExecutionStatistics.Statistics;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.britter.junit.jupiter.testkit.ExecutedElementType.CONTAINER;
import static com.github.britter.junit.jupiter.testkit.ExecutedElementType.TEST;
import static com.github.britter.junit.jupiter.testkit.ExecutionEvent.Type.SKIPPED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.platform.engine.TestExecutionResult.Status.FAILED;

class TestkitExamplesTests {

    @ExtensionTest(InnerTestCase.class)
    void execute_all_methods_of_class(TestExecutionStatistics statistics) {
        assertEquals(1, statistics.getContainerStatistics().getStartedCount());
        assertEquals(1, statistics.getContainerStatistics().getSuccessfulCount());
        assertEquals(0, statistics.getContainerStatistics().getFailedCount());

        assertEquals(3, statistics.getTestStatistics().getStartedCount());
        assertEquals(2, statistics.getTestStatistics().getSuccessfulCount());
        assertEquals(1, statistics.getTestStatistics().getSkippedCount());
        assertEquals(0, statistics.getTestStatistics().getFailedCount());
    }

    @ExtensionTest(InnerTestCase.class)
    void execute_all_methods_of_class_only_analysing_only_container_stats(@ContainerStatistics Statistics containerStats) {
        assertEquals(1, containerStats.getStartedCount());
        assertEquals(1, containerStats.getSuccessfulCount());
        assertEquals(0, containerStats.getFailedCount());
    }

    @ExtensionTest(InnerTestCase.class)
    void execute_all_methods_of_class_only_analysing_only_test_stats(@TestStatistics Statistics testStats) {
        assertEquals(3, testStats.getStartedCount());
        assertEquals(2, testStats.getSuccessfulCount());
        assertEquals(1, testStats.getSkippedCount());
        assertEquals(0, testStats.getFailedCount());
    }

    @ExtensionTest(value = InnerTestCase.class, methods = "test_method_1")
    void execute_selected_methods_of_class(@TestStatistics Statistics testStats) {
        assertEquals(1, testStats.getStartedCount());
        assertEquals(1, testStats.getSuccessfulCount());
        assertEquals(0, testStats.getFailedCount());
    }

    @ExtensionTest(value = InnerTestCase.class, methods = "test_method_2")
    void execute_selected_methods_of_class_analysing_event(ExecutionEvents events) {
        assertEquals(5, events.asList().size());
    }

    @ExtensionTest(value = InnerTestCase.class, methods = "test_method_2")
    void execute_selected_methods_of_class_filtering_only_skipped_events(@EventsFilter(SKIPPED) List<ExecutionEvent> events) {
        assertEquals(1, events.size());
    }

    @ExtensionTest(value = InnerTestCase.class, methods = "test_method_2")
    void execute_selected_methods_of_class_filtering_only_container_events(@EventsFilter(type = CONTAINER) List<ExecutionEvent> events) {
        assertEquals(1, events.size());
    }

    @ExtensionTest(value = InnerTestCase.class, methods = "test_method_2")
    void execute_selected_methods_of_class_filtering_only_failed_tests(@EventsFilter(status = FAILED) List<ExecutionEvent> events) {
        assertEquals(0, events.size());
    }

    @ExtensionTest(value = InnerTestCase.class, methods = "test_method_2")
    void execute_selected_methods_of_class_with_complex_filtering(@EventsFilter(value = ExecutionEvent.Type.FINISHED, type = TEST, status = FAILED) List<ExecutionEvent> events) {
        assertEquals(0, events.size());
    }

    class InnerTestCase {

        @Test
        void test_method_1() {

        }

        @Test
        void test_method_2() {

        }

        @Test
        @Disabled("Disabled for demo purposes")
        void test_method_3() {

        }
    }
}
