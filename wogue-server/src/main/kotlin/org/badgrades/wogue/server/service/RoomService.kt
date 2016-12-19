package org.badgrades.wogue.server.service

import org.badgrades.wogue.server.domain.PlayerSession
import org.badgrades.wogue.server.domain.Room
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * A collection of room-based operations
 */
class RoomService {
    
    val roomMap: ConcurrentHashMap<UUID, Room> = ConcurrentHashMap()
    
    /**
     *
     */
    fun addRoom(r: Room) = roomMap.put(r.id, r)
    
    /**
     *
     */
    fun removeRoom(r: Room) = roomMap.remove(r.id)
    
    /**
     *
     */
    fun addPlayerToRoom(playerSession: PlayerSession, room: Room) {
        room.sessions.add(playerSession)
        playerSession.rooms.add(room.id)
    }
    
    /**
     *
     */
    fun removePlayerFromRoom(playerSession: PlayerSession, room: Room) {
        room.sessions.remove(playerSession)
        playerSession.rooms.remove(room.id)
    }
}