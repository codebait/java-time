package com.codebait.localdate.reportfixed;

import java.time.ZonedDateTime;

class Report {

  private final ZonedDateTime signDate;
  private final String name;
  private boolean processed = false;

  Report(ZonedDateTime signDate, String name) {
    this.signDate = signDate;
    this.name = name;
  }

  ZonedDateTime getSignDate() {
    return signDate;
  }

  String getName() {
    return name;
  }

  boolean isProcessed() {
    return processed;
  }

  void processed() {
    processed = true;
  }
}
