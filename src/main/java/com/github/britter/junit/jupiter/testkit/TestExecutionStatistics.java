package com.github.britter.junit.jupiter.testkit;

public interface TestExecutionStatistics {

    Statistics getTestStatistics();

    Statistics getContainerStatistics();

    interface Statistics {
        // TODO does this belong here?
        long getReportingEntryPublishedCount();

        // TODO does this belong here?
        long getDynamicTestRegisteredCount();

        long getStartedCount();

        long getFinishedCount();

        long getSuccessfulCount();

        long getFailedCount();

        long getSkippedCount();
    }
}
