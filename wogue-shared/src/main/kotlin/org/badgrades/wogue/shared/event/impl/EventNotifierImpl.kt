package org.badgrades.wogue.shared.event.impl

import org.badgrades.wogue.server.network.event.EventObserver
import org.badgrades.wogue.shared.event.EventNotifier
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class EventNotifierImpl : EventNotifier {
    
    val log by LoggerDelegate()
    val executorService: ExecutorService = Executors.newFixedThreadPool(EventNotifier.POOL_SIZE)
    override val observers: HashMap<Event, MutableSet<EventObserver>> = HashMap()
    
    override fun update(message: Message) {
        log.info("Updating observers with event: {} ",
                message.event)
        
        observers[message.event]?.forEach {
            executorService.submit {
                it.update(message)
                log.info("Updated {} with message {}",
                        it,
                        message)
            }
        }
    }
}