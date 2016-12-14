package org.badgrades.wogue.server.service

import org.badgrades.wogue.shared.model.Player
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * A collection of player-based operations
 */
class PlayerService {
    
    val playerMap: ConcurrentHashMap<UUID, Player> = ConcurrentHashMap()
}