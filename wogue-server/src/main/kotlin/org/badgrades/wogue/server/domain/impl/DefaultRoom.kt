package org.badgrades.wogue.server.domain.impl

import org.badgrades.wogue.server.domain.PlayerSession
import org.badgrades.wogue.server.domain.Room
import java.util.*

class DefaultRoom(override val name: String) : Room {
    
    override val id: UUID = UUID.randomUUID()
    override val sessions: MutableCollection<PlayerSession> = mutableListOf()
    
}