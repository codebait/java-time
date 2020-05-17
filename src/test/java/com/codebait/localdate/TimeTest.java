package com.codebait.localdate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;

class TimeTest {


  @Test
  void sameTimeZones() {
    Instant now = Instant.parse("2020-05-10T10:00:00.00Z");
    Clock firstZone = Clock.fixed(now, ZoneId.of("GMT+1"));
    Clock secondZone = Clock.fixed(now, ZoneId.of("GMT+1"));
    LocalDateTime firstZoneTime = LocalDateTime.now(firstZone);
    LocalDateTime secondZoneTime = LocalDateTime.now(secondZone);
    assertEquals(firstZoneTime, secondZoneTime);
  }


  @Test
  void differentTimeZones() {
    Instant now = Instant.parse("2020-05-10T10:00:00.00Z");
    Clock firstZone = Clock.fixed(now, ZoneId.of("GMT+2"));
    Clock secondZone = Clock.fixed(now, ZoneId.of("GMT+1"));
    LocalDateTime firstZoneTime = LocalDateTime.now(firstZone);
    LocalDateTime secondZoneTime = LocalDateTime.now(secondZone);
    assertTrue(firstZoneTime.isEqual(secondZoneTime));

  }


  @Test
  void differentTimeZonesWithZonedDataTime() {
    Instant now = Instant.parse("2020-05-10T10:00:00.00Z");
    Clock firstZone = Clock.fixed(now, ZoneId.of("GMT+2"));
    Clock secondZone = Clock.fixed(now, ZoneId.of("GMT+1"));
    ZonedDateTime firstZoneTime = ZonedDateTime.now(firstZone);
    ZonedDateTime secondZoneTime = ZonedDateTime.now(secondZone);
    assertTrue(firstZoneTime.isEqual(secondZoneTime));

  }


  @Test
  void durationBetweenSameTimeZones() {
    Instant firstTime = Instant.parse("2020-05-10T10:00:00.00Z");
    Instant secondTime = Instant.parse("2020-05-10T10:01:00.00Z");
    Clock firstZone = Clock.fixed(firstTime, ZoneId.of("GMT+1"));
    Clock secondZone = Clock.fixed(secondTime, ZoneId.of("GMT+1"));
    LocalDateTime firstZoneTime = LocalDateTime.now(firstZone);
    LocalDateTime secondZoneTime = LocalDateTime.now(secondZone);
    assertEquals(60, Duration.between(firstZoneTime, secondZoneTime).getSeconds());

  }


  @Test
  void durationBetweenDifferentTimeZones() {
    Instant firstTime = Instant.parse("2020-05-10T10:00:00.00Z");
    Instant secondTime = Instant.parse("2020-05-10T10:01:00.00Z");
    Clock firstZone = Clock.fixed(firstTime, ZoneId.of("GMT+1"));
    Clock secondZone = Clock.fixed(secondTime, ZoneId.of("GMT+2"));
    LocalDateTime firstZoneTime = LocalDateTime.now(firstZone);
    LocalDateTime secondZoneTime = LocalDateTime.now(secondZone);
    assertEquals(60, Duration.between(firstZoneTime, secondZoneTime).getSeconds());

  }


  @Test
  void durationBetweenDifferentTimeZonesWithZonedDataTime() {
    Instant firstTime = Instant.parse("2020-05-10T10:00:00.00Z");
    Instant secondTime = Instant.parse("2020-05-10T10:01:00.00Z");
    Clock firstZone = Clock.fixed(firstTime, ZoneId.of("GMT+1"));
    Clock secondZone = Clock.fixed(secondTime, ZoneId.of("GMT+2"));
    ZonedDateTime firstZoneTime = ZonedDateTime.now(firstZone);
    ZonedDateTime secondZoneTime = ZonedDateTime.now(secondZone);
    assertEquals(60, Duration.between(firstZoneTime, secondZoneTime).getSeconds());

  }
}
