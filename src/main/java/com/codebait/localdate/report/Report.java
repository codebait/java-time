package com.codebait.localdate.report;

import java.time.LocalDateTime;

class Report {

  private final LocalDateTime signDate;
  private final String name;
  private boolean processed = false;

  Report(LocalDateTime signDate, String name) {
    this.signDate = signDate;
    this.name = name;
  }

  LocalDateTime getSignDate() {
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
