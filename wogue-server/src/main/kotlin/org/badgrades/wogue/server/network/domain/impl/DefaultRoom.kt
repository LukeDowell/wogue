package org.badgrades.wogue.server.network.domain.impl

import org.badgrades.wogue.server.network.domain.PlayerSession
import org.badgrades.wogue.server.network.domain.Room
import org.badgrades.wogue.shared.network.Event
import java.util.*

/**
 * A default container for player sessions
 */
class DefaultRoom(override val name: String,
                  override val events: Collection<Event>) : Room {
    
    override val id: UUID = UUID.randomUUID()
    override val sessions: MutableCollection<PlayerSession> = mutableListOf()
    
}