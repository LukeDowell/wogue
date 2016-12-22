package org.badgrades.wogue.server.event

import org.badgrades.wogue.server.domain.PlayerSession
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message
import java.util.*

interface SessionEventNotifier {
    
    companion object {
        const val POOL_SIZE = 6
    }
    
    val observers: HashMap<Event, MutableSet<SessionEventHandler>>
    
    fun addObserver(event: Event, observer: SessionEventHandler) {
        if (observers[event] == null) {
            observers[event] = mutableSetOf()
        }
        
        observers[event]?.add(observer)
    }
    
    fun removeObserver(event: Event, observer: SessionEventHandler) = observers[event]?.remove(observer)
    
    fun update(message: Message, playerSession: PlayerSession)
}