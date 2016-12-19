package org.badgrades.client

import com.google.inject.Guice
import org.badgrades.client.network.WogueClient

class ClientMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            
            // Build object graph
            val injector = Guice.createInjector(ClientModule())
            
            // Start the server
            val server = injector.getInstance(WogueClient::class.java)
            server.connect()
        }
    }
}