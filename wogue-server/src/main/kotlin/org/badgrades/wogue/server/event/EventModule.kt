package org.badgrades.wogue.server.event

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import org.badgrades.wogue.server.event.impl.SessionEventNotifierImpl

class EventModule : AbstractModule() {
    
    override fun configure() {
        bind(SessionEventNotifier::class.java).to(SessionEventNotifierImpl::class.java).`in`(Singleton::class.java)
    }
}