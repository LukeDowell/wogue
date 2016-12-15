package org.badgrades.wogue.server

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import org.badgrades.wogue.server.network.WogueServer
import org.badgrades.wogue.server.service.PlayerService
import org.badgrades.wogue.server.service.RoomService
import org.badgrades.wogue.shared.event.EventNotifier
import org.badgrades.wogue.shared.event.impl.EventNotifierImpl

class ServiceModule : AbstractModule() {
    
    override fun configure() {
        
        bind(PlayerService::class.java).asEagerSingleton()
        bind(RoomService::class.java).asEagerSingleton()
        
        bind(EventNotifier::class.java).to(EventNotifierImpl::class.java).`in`(Singleton::class.java)
        
        bind(WogueServer::class.java).asEagerSingleton()
        
    }
}