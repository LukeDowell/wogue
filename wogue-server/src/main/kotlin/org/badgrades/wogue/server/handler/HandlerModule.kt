package org.badgrades.wogue.server.handler

import com.google.inject.AbstractModule
import com.google.inject.multibindings.Multibinder
import org.badgrades.wogue.server.event.SessionEventHandler

class HandlerModule : AbstractModule(){
    override fun configure() {
        val handlerMultibinder = Multibinder.newSetBinder(binder(), SessionEventHandler::class.java)
        handlerMultibinder.addBinding().to(ChatHandler::class.java)
        handlerMultibinder.addBinding().to(LoginHandler::class.java)
    }
}