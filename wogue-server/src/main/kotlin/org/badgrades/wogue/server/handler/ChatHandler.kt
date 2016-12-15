package org.badgrades.wogue.server.handler

import com.google.inject.Inject
import org.badgrades.wogue.server.service.PlayerService
import org.badgrades.wogue.server.service.RoomService
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message

/**
 * Handles chat messages
 */
class ChatHandler
@Inject constructor(roomService: RoomService, playerService: PlayerService): ServerEventHandler() {
    
    override val eventsToListenFor: Collection<Event> = listOf(Event.CHAT_MESSAGE)
    
    override fun update(message: Message) {
        
    }
}