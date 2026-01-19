package org.example.core.plugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class PluginManager {

    private static final Logger log = LoggerFactory.getLogger(PluginManager.class);

    private static final List<PlugIn> plugins = new ArrayList<>();

    private PluginManager() {
    }

    public static void register(PlugIn plugin) {
        plugins.add(plugin);
        log.info("🔌 Plugin registered: {}", plugin.name());
    }

    public static void startAll() {
        for (PlugIn plugin : plugins) {
            log.info("▶️ Starting plugin: {}", plugin.name());
            plugin.start();
        }
    }

    public static void stopAll() {
        for (PlugIn plugin : plugins) {
            log.info("⏹️ Stopping plugin: {}", plugin.name());
            plugin.stop();
        }
    }
}
