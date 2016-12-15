package org.badgrades.wogue.server.network.event

import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Maintains a list of observers and updates them when certain network messages are received
 */
class EventNotifier {
    
    val log by LoggerDelegate()
    val POOL_SIZE = 6
    val executorService: ExecutorService = Executors.newFixedThreadPool(POOL_SIZE)
    
    private val observers: HashMap<Event, MutableSet<EventObserver>> = HashMap()
    
    fun addObserver(event: Event, observer: EventObserver) {
        if (observers[event] == null) {
            observers[event] = mutableSetOf()
        }
        
        observers[event]?.add(observer)
    }
    
    fun removeObserver(event: Event, observer: EventObserver) = observers[event]?.remove(observer)
    
    fun update(message: Message) {
        log.info("Updating observers with event: {} ",
                message.event)
        
        observers[message.event]?.forEach {
            executorService.submit { it.update(message) }
        }
    }
}