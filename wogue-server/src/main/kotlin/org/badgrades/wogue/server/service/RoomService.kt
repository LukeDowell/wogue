package org.badgrades.wogue.server.service

import org.badgrades.wogue.server.network.domain.Room
import org.badgrades.wogue.server.network.domain.impl.DefaultRoom
import org.badgrades.wogue.shared.network.Event
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * A collection of room-based operations
 */
class RoomService {
    
    val roomMap: ConcurrentHashMap<UUID, Room> = ConcurrentHashMap()
    
    init {
        // Create the chat room that all players will belong to
        val broadcastChatRoom = DefaultRoom(
                "BroadcastChatRoom",
                listOf(
                        Event.CHAT,
                        Event.PLAYER_JOINED
                )
        )
        addRoom(broadcastChatRoom)
        
        //
        val mapRoom = DefaultRoom(
                "MapRoom",
                listOf(
                        Event.PLAYER_MOVED,
                        Event.PLAYER_JOINED
                )
        )
        addRoom(mapRoom)
    }
    
    fun addRoom(r: Room) = roomMap.put(r.id, r)
    fun removeRoom(r: Room) = roomMap.remove(r.id)
}