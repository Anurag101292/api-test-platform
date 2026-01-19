package org.example.core.event;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {

    private static final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listeners =
            new ConcurrentHashMap<>();

    private EventBus() {
        // no instance
    }

    public static <E extends Event> void register(Class<E> eventType, EventListener<E> listener) {
        listeners
                .computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>())
                .add(listener);
    }

    @SuppressWarnings("unchecked")
    public static <E extends Event> void publish(E event) {
        List<EventListener<? extends Event>> eventListeners = listeners.get(event.getClass());

        if (eventListeners == null) {
            return;
        }

        for (EventListener<? extends Event> listener : eventListeners) {
            ((EventListener<E>) listener).onEvent(event);
        }
    }

    public static void clear() {
        listeners.clear();
    }
}
