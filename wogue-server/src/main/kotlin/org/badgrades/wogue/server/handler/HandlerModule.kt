package org.badgrades.wogue.server.handler

import com.google.inject.AbstractModule
import com.google.inject.multibindings.Multibinder

class HandlerModule : AbstractModule() {
    override fun configure() {
        val handlerMultibinder = Multibinder.newSetBinder(binder(), ServerEventHandler::class.java)
        handlerMultibinder.addBinding().to(ChatHandler::class.java)
        handlerMultibinder.addBinding().to(LoginHandler::class.java)
    }
}