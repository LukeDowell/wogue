package org.badgrades.wogue.server.handler

import com.google.inject.Inject
import org.badgrades.wogue.server.event.SessionEventHandler
import org.badgrades.wogue.server.event.SessionEventNotifier
import org.badgrades.wogue.shared.util.LoggerDelegate

class HandlerInitializer {
    
    val log by LoggerDelegate()
    
    @Inject var eventNotifier: SessionEventNotifier? = null
    @Inject var sessionEventHandlers: java.util.Set<SessionEventHandler>? = null // java.util.Set necessary for Multibinder injection
    
    fun init() {
        sessionEventHandlers?.forEach { handler ->
            handler.eventsToListenFor.forEach { event ->
                log.info("Registering {} to event {}",
                        handler.javaClass.simpleName,
                        event)
                eventNotifier?.addObserver(event, handler)
            }
        }
    }
}