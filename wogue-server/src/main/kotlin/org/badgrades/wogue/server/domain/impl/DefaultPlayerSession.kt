package org.badgrades.wogue.server.domain.impl

import io.netty.channel.Channel
import org.badgrades.wogue.server.domain.PlayerSession
import org.badgrades.wogue.shared.model.Player
import java.util.*

class DefaultPlayerSession(
        override val channel: Channel,
        override val player: Player
) : PlayerSession() {
    
    override var state: PlayerSession.STATUS = PlayerSession.STATUS.OPEN
    
    override val rooms: MutableSet<UUID> = mutableSetOf()
}