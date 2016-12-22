package org.badgrades.wogue.server.handler

import com.google.inject.Inject
import org.badgrades.wogue.server.domain.PlayerSession
import org.badgrades.wogue.server.event.SessionEventHandler
import org.badgrades.wogue.server.service.PlayerService
import org.badgrades.wogue.server.service.RoomService
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate

/**
 * Handles chat messages
 */
class ChatHandler
@Inject constructor(
        roomService: RoomService,
        playerService: PlayerService
) : SessionEventHandler {
    
    override val eventsToListenFor: Collection<Event> = listOf(Event.CHAT_MESSAGE)
    val log by LoggerDelegate()
    
    init {
        log.info("Chat Handler init {} {}", roomService, playerService)
    }
    
    override fun update(message: Message, playerSession: PlayerSession) {
        log.info("Message received: {} from session: {}", message, playerSession.channel.id().asShortText())
    }
}