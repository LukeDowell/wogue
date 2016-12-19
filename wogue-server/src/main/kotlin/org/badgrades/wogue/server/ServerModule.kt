package org.badgrades.wogue.server

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import com.google.inject.multibindings.Multibinder
import org.badgrades.wogue.server.handler.ChatHandler
import org.badgrades.wogue.server.handler.LoginHandler
import org.badgrades.wogue.server.handler.ServerEventHandler
import org.badgrades.wogue.server.network.WogueServer
import org.badgrades.wogue.server.network.netty.*
import org.badgrades.wogue.server.service.PlayerService
import org.badgrades.wogue.server.service.RoomService
import org.badgrades.wogue.shared.event.EventNotifier
import org.badgrades.wogue.shared.event.impl.EventNotifierImpl

class ServerModule : AbstractModule() {
    
    override fun configure() {
        
        // SUUUUURVICE
        bind(PlayerService::class.java).asEagerSingleton()
        bind(RoomService::class.java).asEagerSingleton()

        // HANDLERS
        // CAPS WOOO
        val handlerMultibinder = Multibinder.newSetBinder(binder(), ServerEventHandler::class.java)
        handlerMultibinder.addBinding().to(ChatHandler::class.java)
        handlerMultibinder.addBinding().to(LoginHandler::class.java)
    
        // DANK SERVER COMPONENTS
        bind(RootChannelInitializer::class.java).asEagerSingleton()
        bind(EventNotifier::class.java).to(EventNotifierImpl::class.java).`in`(Singleton::class.java)
        bind(LoginAdapter::class.java).toProvider(LoginAdapterProvider::class.java)
        bind(EventDispatcherAdapter::class.java).toProvider(EventDispatcherAdapterProvider::class.java)
        bind(WogueServer::class.java).asEagerSingleton()
    }
}