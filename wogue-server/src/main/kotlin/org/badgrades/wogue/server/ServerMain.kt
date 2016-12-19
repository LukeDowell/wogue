package org.badgrades.wogue.server

import com.google.inject.Guice
import org.badgrades.wogue.server.handler.HandlerInitializer
import org.badgrades.wogue.server.handler.HandlerModule
import org.badgrades.wogue.server.network.NetworkModule
import org.badgrades.wogue.server.network.WogueServer
import org.badgrades.wogue.server.service.ServiceModule

class ServerMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            
            // Build object graph
            val injector = Guice.createInjector(
                    ServiceModule(),
                    HandlerModule(),
                    NetworkModule()
            )
            
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