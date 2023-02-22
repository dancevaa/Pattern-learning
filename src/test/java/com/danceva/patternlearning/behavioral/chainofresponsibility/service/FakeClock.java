package com.danceva.patternlearning.behavioral.chainofresponsibility.service;

import static java.time.LocalDateTime.parse;
import static java.time.ZoneId.systemDefault;

import java.time.*;
import java.util.TimeZone;

public class FakeClock extends Clock {

    private Clock delegate;

    public FakeClock() {
        setDateTime("2023-01-01T00:00:00");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    public void setDateTime(final String isoDateTime) {
        final ZonedDateTime zonedDate = toZonedDateTime(isoDateTime);
        delegate = fixed(zonedDate.toInstant(), zonedDate.getZone());
    }

    @Override
    public ZoneId getZone() {
        return delegate.getZone();
    }

    @Override
    public Clock withZone(final ZoneId zone) {
        return delegate.withZone(zone);
    }

    @Override
    public Instant instant() {
        return delegate.instant();
    }

    private ZonedDateTime toZonedDateTime(final String isoDateTime) {
        return toZonedDateTime(parse(isoDateTime));
    }

    private ZonedDateTime toZonedDateTime(final LocalDateTime ldt) {
        return ldt.atZone(systemDefault());
    }
}
