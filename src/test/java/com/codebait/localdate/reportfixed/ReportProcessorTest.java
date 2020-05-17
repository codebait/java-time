package com.codebait.localdate.reportfixed;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReportProcessorTest {

  private ReportProcessor reportProcessor;

  @Test
  void shouldProcessReportAfterMinute() {
    // given
    Clock firstMinute = Clock
        .fixed(Instant.parse("2020-10-25T00:58:00.00Z"), ZoneId.systemDefault());
    Clock secondMinute = Clock
        .fixed(Instant.parse("2020-10-25T00:59:00.00Z"), ZoneId.systemDefault());

    // when
    Report report = new Report(
        ZonedDateTime.now(firstMinute), "Raport roczny");
    reportProcessor = new ReportProcessor(secondMinute);
    reportProcessor.processReport(report);
    // then
    Assertions.assertTrue(report.isProcessed());
  }


  @Test
  void shouldProcessReportAfterMinuteWithDifferentTimeZones() {
    // given
    ZoneId zone = ZoneId.systemDefault();
    Clock firstMinute = Clock
        .fixed(Instant.parse("2020-10-25T00:59:00.00Z"), zone);
    Clock secondMinute = Clock
        .fixed(Instant.parse("2020-10-25T01:00:00.00Z"), zone);

    // when
    Report report = new Report(ZonedDateTime.now(firstMinute), "Raport roczny");
    reportProcessor = new ReportProcessor(secondMinute);
    reportProcessor.processReport(report);
    // then
    Assertions.assertTrue(report.isProcessed());
  }


}
