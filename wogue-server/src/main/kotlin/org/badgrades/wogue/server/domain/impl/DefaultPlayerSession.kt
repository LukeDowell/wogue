package org.badgrades.wogue.server.domain.impl

import io.netty.channel.socket.SocketChannel
import org.badgrades.wogue.server.domain.PlayerSession
import org.badgrades.wogue.shared.model.Player
import java.awt.Point
import java.util.*

class DefaultPlayerSession(override var channel: SocketChannel) : PlayerSession {
    
    override var player: Player = Player(
            channel.id().asShortText(),
            Point(5, 5)
    )
    
    override var state: PlayerSession.STATUS = PlayerSession.STATUS.OPEN
    
    override val rooms: MutableCollection<UUID> = mutableListOf()
}