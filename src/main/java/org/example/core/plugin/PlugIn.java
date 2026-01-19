package org.example.core.plugin;

public interface PlugIn {

    /**
     * Called when framework starts.
     */
    void start();

    /**
     * Called when framework shuts down.
     */
    void stop();

    /**
     * Plugin name (for logging, debugging)
     */
    String name();
}
