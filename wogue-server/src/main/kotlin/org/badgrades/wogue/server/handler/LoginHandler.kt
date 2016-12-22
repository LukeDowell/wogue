package org.badgrades.wogue.server.handler

import com.google.inject.Inject
import org.badgrades.wogue.server.domain.PlayerSession
import org.badgrades.wogue.server.event.SessionEventHandler
import org.badgrades.wogue.server.service.PlayerService
import org.badgrades.wogue.server.service.RoomService
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message

class LoginHandler
@Inject constructor(
        roomService: RoomService,
        playerService: PlayerService
) : SessionEventHandler {
    
    override val eventsToListenFor: Collection<Event> = listOf(Event.PLAYER_JOINED)
    
    override fun update(message: Message, playerSession: PlayerSession) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}