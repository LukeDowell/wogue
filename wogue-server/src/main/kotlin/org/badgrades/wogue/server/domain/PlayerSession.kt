package org.badgrades.wogue.server.domain

import io.netty.channel.socket.SocketChannel
import org.badgrades.wogue.shared.model.Player
import java.util.*

/**
 * Represents an open connection to the server
 */
interface PlayerSession {
    
    /**
     *
     */
    var state: STATUS
    
    /**
     *
     */
    val channel: SocketChannel
    
    /**
     *
     */
    val player: Player
    
    /**
     * A list of room IDs to which this player belongs
     */
    val rooms: MutableSet<UUID>
    
    /**
     *
     */
    enum class STATUS {
        OPEN, CLOSED
    }
}

