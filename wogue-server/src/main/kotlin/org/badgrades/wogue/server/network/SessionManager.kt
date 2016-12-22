package org.badgrades.wogue.server.network

import com.google.inject.Inject
import io.netty.channel.Channel
import org.badgrades.wogue.server.domain.PlayerSession
import org.badgrades.wogue.shared.util.LoggerDelegate
import java.util.concurrent.ConcurrentHashMap

/**
 * Manages player sessions. Why is this different from the player and room service?
 */
class SessionManager
@Inject constructor() {
    
    val log by LoggerDelegate()
    
    /**
     * Concurrent hashmap of player sessions. Might not need to
     */
    val sessions: ConcurrentHashMap<String, PlayerSession> = ConcurrentHashMap()
    
    /**
     * Adds a session to the map of active sessions
     */
    fun addSession(session: PlayerSession) {
        log.info("Adding session with id: {}", session.id)
        sessions.put(session.id, session)
    }
    
    /**
     * Removes a session
     */
    fun removeSession(id: String) {
        log.info("Removing session with id: {} ", id)
        sessions.remove(id)
    }
    
    
    /**
     * Returns a session. Uses the short text channel id as a key
     */
    fun getSessionFromChannel(channel: Channel) : PlayerSession? = sessions[channel.id().asShortText()]
}