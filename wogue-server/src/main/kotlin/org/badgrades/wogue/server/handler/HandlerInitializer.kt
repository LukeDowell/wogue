package org.badgrades.wogue.server.handler

import com.google.inject.Inject
import org.badgrades.wogue.shared.event.EventNotifier
import org.badgrades.wogue.shared.util.LoggerDelegate

class HandlerInitializer {
    
    val log by LoggerDelegate()
    
    @Inject var eventNotifier: EventNotifier? = null
    @Inject var serverEventHandlers: java.util.Set<ServerEventHandler>? = null // java.util.Set necessary for Multibinder injection
    
    fun init() {
        serverEventHandlers?.forEach { handler ->
            handler.eventsToListenFor.forEach { event ->
                log.info("Registering {} to event {}",
                        handler.javaClass.simpleName,
                        event)
                eventNotifier?.addObserver(event, handler)
            }
        }
    }
}