package org.badgrades.wogue.server.handler

import com.google.inject.Inject
import org.badgrades.wogue.server.service.PlayerService
import org.badgrades.wogue.server.service.RoomService
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message

class LoginHandler
@Inject constructor(roomService: RoomService, playerService: PlayerService): ServerEventHandler() {

    override fun update(message: Message) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val eventsToListenFor: Collection<Event> = listOf(Event.PLAYER_JOINED)
}