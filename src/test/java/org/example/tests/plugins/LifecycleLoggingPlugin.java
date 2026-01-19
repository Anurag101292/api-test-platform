package org.example.tests.plugins;

import org.example.core.event.EventBus;
import org.example.core.event.events.FrameworkStartedEvent;
import org.example.core.event.events.FrameworkStoppedEvent;
import org.example.core.plugin.PlugIn;
import org.example.tests.listeners.FrameworkStartedLogger;
import org.example.tests.listeners.FrameworkStoppedLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifecycleLoggingPlugin implements PlugIn {

    private static final Logger log = LoggerFactory.getLogger(LifecycleLoggingPlugin.class);

    @Override
    public String name() {
        return "LifecycleLoggingPlugin";
    }

    @Override
    public void start() {
        log.info("🔌 {} starting", name());

        // Register listeners
        EventBus.register(FrameworkStartedEvent.class, new FrameworkStartedLogger());
        EventBus.register(FrameworkStoppedEvent.class, new FrameworkStoppedLogger());
    }

    @Override
    public void stop() {
        log.info("🔌 {} stopping", name());
    }
}
