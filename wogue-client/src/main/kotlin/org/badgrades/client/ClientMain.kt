package org.badgrades.client

import com.google.inject.Guice
import com.sun.deploy.util.SessionState
import org.badgrades.client.game.GameModule
import org.badgrades.client.gui.ClientFrame
import org.badgrades.client.gui.GuiModule
import org.badgrades.client.network.NetworkModule
import org.badgrades.client.network.WogueClient

class ClientMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            
            // Build object graph
            val injector = Guice.createInjector(
                    GameModule(),
                    GuiModule(),
                    NetworkModule()
            )
            
            // Start the server
            val server = injector.getInstance(WogueClient::class.java)
            server.connect()

            val clientFrame = ClientFrame()
            injector.injectMembers(clientFrame)
            clientFrame.initialize()
        }
    }
}