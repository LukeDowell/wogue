package org.badgrades.wogue.server.service

import org.badgrades.wogue.server.domain.Room
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * A collection of room-based operations
 */
class RoomService {
    
    val roomMap: ConcurrentHashMap<UUID, Room> = ConcurrentHashMap()
    
    init {
    }
    
    fun addRoom(r: Room) = roomMap.put(r.id, r)
    fun removeRoom(r: Room) = roomMap.remove(r.id)
}