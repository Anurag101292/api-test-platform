package org.example.tests.listeners;

import org.example.core.event.EventListener;
import org.example.core.event.events.FrameworkStartedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrameworkStartedLogger implements EventListener<FrameworkStartedEvent> {

    private static final Logger log = LoggerFactory.getLogger(FrameworkStartedLogger.class);

    @Override
    public void onEvent(FrameworkStartedEvent event) {
        log.info("🎯 Listener received FrameworkStartedEvent");
    }
}
