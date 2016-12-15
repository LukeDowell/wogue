package org.badgrades.wogue.server.domain

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
     * A name for this room. Uniqueness is not enforced.
     */
    val name: String
    
    /**
     * A collection of all player sessions associated with this room
     */
    val sessions: MutableCollection<PlayerSession>
    
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