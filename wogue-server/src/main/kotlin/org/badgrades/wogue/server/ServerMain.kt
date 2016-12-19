package org.badgrades.wogue.server

import com.google.inject.Guice
import org.badgrades.wogue.server.handler.HandlerInitializer
import org.badgrades.wogue.server.network.WogueServer

class ServerMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            
            // Build object graph
            val injector = Guice.createInjector(ServerModule())
            
            // Initialize handlers
            val handlerInitializer = HandlerInitializer()
            injector.injectMembers(handlerInitializer)
            handlerInitializer.init()
            
            // Start server
            val server = injector.getInstance(WogueServer::class.java)
            server.start()
        }
    }
}