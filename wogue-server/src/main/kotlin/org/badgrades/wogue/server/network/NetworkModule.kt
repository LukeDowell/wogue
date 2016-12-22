package org.badgrades.wogue.server.network

import com.google.inject.AbstractModule
import org.badgrades.wogue.server.network.netty.EventDispatcherAdapter
import org.badgrades.wogue.server.network.netty.RootChannelInitializer
import org.badgrades.wogue.server.network.netty.SessionAdapter

class NetworkModule : AbstractModule() {
    override fun configure() {
        bind(RootChannelInitializer::class.java).asEagerSingleton()
        bind(WogueServer::class.java).asEagerSingleton()
        bind(SessionManager::class.java).asEagerSingleton()
        bind(SessionAdapter::class.java).asEagerSingleton()
        bind(EventDispatcherAdapter::class.java).asEagerSingleton()
    }
}