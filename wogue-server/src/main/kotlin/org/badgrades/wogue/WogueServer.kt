package org.badgrades.wogue

import com.esotericsoftware.kryonet.Connection
import com.esotericsoftware.kryonet.Listener
import com.esotericsoftware.kryonet.Server
import org.badgrades.wogue.net.Network.Companion.TCP_PORT
import org.badgrades.wogue.net.Network.Companion.UDP_PORT
import org.badgrades.wogue.util.LoggerDelegate

class WogueServer {

    val server = Server()
    val log by LoggerDelegate()

    init {
        log.info(
                "Starting WogueServer on TCP port: {} and UDP port: {}",
                TCP_PORT,
                UDP_PORT
        )
        
        // Start and bind
        server.start()
        server.bind(
                TCP_PORT,
                UDP_PORT
        )
        
        log.info("Server started successfully!")

        // Setup listener/s
        server.addListener(object : Listener() { // TODO pull this out
            override fun received(connection: Connection?, message: Any?) {
                log.info("Message received from client with id: {} Message: {}", connection?.id, message)
                
                connection?.sendTCP("Message received!")
            }
        })
    }
}