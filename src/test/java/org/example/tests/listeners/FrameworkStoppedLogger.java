package org.example.tests.listeners;

import org.example.core.event.EventListener;
import org.example.core.event.events.FrameworkStoppedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrameworkStoppedLogger implements EventListener<FrameworkStoppedEvent> {

    private static final Logger log = LoggerFactory.getLogger(FrameworkStoppedLogger.class);

    @Override
    public void onEvent(FrameworkStoppedEvent event) {
        log.info("🎯 Listener received FrameworkStoppedEvent");
    }
}
