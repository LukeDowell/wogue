package org.badgrades.wogue.server.service

import org.badgrades.wogue.server.network.domain.Room
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * A collection of room-based operations
 */
class RoomService {
    
    val roomMap: ConcurrentHashMap<UUID, Room> = ConcurrentHashMap()
}