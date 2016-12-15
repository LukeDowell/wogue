package org.badgrades.wogue.server.network.domain

import org.badgrades.wogue.shared.network.Event
import java.util.*

/**
 * A collection of PlayerSessions that are interested in being updated in a set of events.
 * A chat room would want to know about messages being broadcast to the server, a map room
 * would want to know about player's movements in a given area, etc.
 */
interface Room {
    
    /**
     * A unique identifier for this room
     */
    val id: UUID
    
    /**
     * A name for this room. Probably should also be unique, how to enforce?
     */
    val name: String
    
    /**
     * A collection of all player sessions associated with this room
     */
    val sessions: MutableCollection<PlayerSession>
    
    /**
     * A list of all the events that this room cares about
     */
    val events: Collection<Event>
    
    /**
     * Convenient function for joining a room
     */
    fun join(playerSession: PlayerSession) {
        sessions.add(playerSession)
        playerSession.rooms.add(id)
    }
    
    /**
     * Convenient function for leaving a room
     */
    fun leave(playerSession: PlayerSession) {
        sessions.remove(playerSession)
        playerSession.rooms.remove(id)
    }
}