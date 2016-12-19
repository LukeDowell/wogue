package org.badgrades.wogue.shared.event

import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message

/**
 * Abstract class for objects that want to be notified of certain events
 */
interface EventObserver {
    
    /**
     * A list of events that this observer cares about
     */
    val eventsToListenFor: Collection<Event>
    
    /**
     * The function called when a message is received that has an event contained in
     * eventsToListenFor
     */
    fun update(message: Message)
    
}