package org.badgrades.wogue.server.event.impl

import org.badgrades.wogue.server.domain.PlayerSession
import org.badgrades.wogue.server.event.SessionEventHandler
import org.badgrades.wogue.server.event.SessionEventNotifier
import org.badgrades.wogue.shared.network.Event
import org.badgrades.wogue.shared.network.Message
import org.badgrades.wogue.shared.util.LoggerDelegate
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class SessionEventNotifierImpl : SessionEventNotifier {
    
    val log by LoggerDelegate()
    override val observers: HashMap<Event, MutableSet<SessionEventHandler>> = hashMapOf()
    val executorService: ExecutorService = Executors.newFixedThreadPool(SessionEventNotifier.POOL_SIZE)
    
    override fun update(message: Message, playerSession: PlayerSession) {
        observers[message.event]?.forEach {
            executorService.submit { it.update(message, playerSession)  }
        }
    }
}