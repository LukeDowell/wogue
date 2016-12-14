package org.badgrades.wogue.server.netty

import java.util.*

/**
 * A collection of PlayerSessions that are interested in being updated in a set of events.
 * A chat room would want to know about messages being broadcast to the server, a map room
 * would want to know about player's movements in a given area, etc.
 */
class Room(val id: UUID = UUID.randomUUID(),
           val name: String) {
    
    val sessions = mutableListOf<PlayerSession>()
}