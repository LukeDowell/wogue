package org.badgrades.wogue.server.domain

import io.netty.channel.Channel
import org.badgrades.wogue.shared.model.Player
import java.util.*

/**
 * Represents an open connection to the server
 */
abstract class PlayerSession {
    
    /**
     * This looks kind of weird, seems like the best way to do private
     * fields in a primary constructor
     */
    abstract val channel: Channel
    
    /**
     *
     */
    abstract var state: STATUS
    
    /**
     *
     */
    abstract val player: Player
    
    /**
     * A list of room IDs to which this player belongs
     */
    abstract val rooms: MutableSet<UUID> // Is a set of uuids redundant?
    
    /**
     *
     */
    val id: String
        get() = channel.id().asShortText()
    
    /**
     *
     */
    enum class STATUS {
        OPEN, CLOSED
    }
}

