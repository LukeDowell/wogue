package org.badgrades.wogue.server.event

import org.badgrades.wogue.server.domain.PlayerSession
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message

/**
 * Controllers for various kinds of events. Should these be singletons? Should this be in the handler package?
 */
interface SessionEventHandler {
    /**
     * A list of events that this observer cares about
     */
    val eventsToListenFor: Collection<Event>
    
    /**
     * The function called when a message is received that has an event contained in
     * eventsToListenFor
     */
    fun update(message: Message, playerSession: PlayerSession)
}