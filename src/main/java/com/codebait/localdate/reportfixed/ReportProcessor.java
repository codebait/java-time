package com.codebait.localdate.reportfixed;

import java.time.Clock;
import java.time.ZonedDateTime;

class ReportProcessor {

  private final Clock clock;

  public ReportProcessor(Clock clock) {
    this.clock = clock;
  }

  void processReport(Report report) {
    if (report.getSignDate().isAfter(ZonedDateTime.now(clock))) {
      throw new IllegalArgumentException("Report " + report.getName() + " has future date.");
    }
    report.processed();
  }
}
