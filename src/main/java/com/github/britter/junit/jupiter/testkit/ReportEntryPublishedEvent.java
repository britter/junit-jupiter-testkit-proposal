package com.github.britter.junit.jupiter.testkit;

import org.junit.platform.engine.reporting.ReportEntry;

public interface ReportEntryPublishedEvent extends ExecutionEvent {

    ReportEntry getReportEnty();
}
