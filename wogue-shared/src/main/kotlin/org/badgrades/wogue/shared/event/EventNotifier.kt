package org.badgrades.wogue.shared.event

import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message
import java.util.*

/**
 * Maintains a list of observers and updates them when certain network messages are received
 */
interface EventNotifier {
    
    companion object {
        const val POOL_SIZE = 6
    }
    
    val observers: HashMap<Event, MutableSet<EventObserver>>
    
    fun addObserver(event: Event, observer: EventObserver) {
        if (observers[event] == null) {
            observers[event] = mutableSetOf()
        }
        
        observers[event]?.add(observer)
    }
    
    fun removeObserver(event: Event, observer: EventObserver) = observers[event]?.remove(observer)
    
    fun update(message: Message)
}