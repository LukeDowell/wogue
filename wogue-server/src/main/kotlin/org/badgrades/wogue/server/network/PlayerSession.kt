package org.badgrades.wogue.server.network

import io.netty.channel.socket.SocketChannel
import org.badgrades.wogue.shared.model.Player

/**
 * Represents an open connection to the server
 */
class PlayerSession {
    
    var state: STATUS = STATUS.CLOSED
    var channel: SocketChannel? = null
    var player: Player? = null
    
    /**
     *
     */
    enum class STATUS {
        OPEN, CLOSED
    }
}

