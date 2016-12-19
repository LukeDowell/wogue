package org.badgrades.wogue.server.network

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import org.badgrades.wogue.server.network.netty.*
import org.badgrades.wogue.shared.event.EventNotifier
import org.badgrades.wogue.shared.event.impl.EventNotifierImpl

class NetworkModule : AbstractModule() {
    override fun configure() {
        bind(RootChannelInitializer::class.java).asEagerSingleton()
        bind(WogueServer::class.java).asEagerSingleton()
        bind(SessionManager::class.java).asEagerSingleton()
        
        bind(EventNotifier::class.java).to(EventNotifierImpl::class.java).`in`(Singleton::class.java)
    
        bind(LoginAdapter::class.java).toProvider(LoginAdapterProvider::class.java)
        bind(EventDispatcherAdapter::class.java).toProvider(EventDispatcherAdapterProvider::class.java)
    }
}