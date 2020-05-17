package com.codebait.localdate.report;

import java.time.Clock;
import java.time.LocalDateTime;

class ReportProcessor {

  private final Clock clock;

  public ReportProcessor(Clock clock) {
    this.clock = clock;
  }

  void processReport(Report report) {
    if (report.getSignDate().isAfter(LocalDateTime.now(clock))) {
      throw new IllegalArgumentException("Report " + report.getName() + " has future date.");
    }
    report.processed();
  }
}
