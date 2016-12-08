package org.badgrades.wogue

import com.esotericsoftware.kryonet.Client
import com.esotericsoftware.kryonet.Connection
import com.esotericsoftware.kryonet.Listener
import org.badgrades.wogue.net.Network
import org.badgrades.wogue.util.LoggerDelegate

class WogueClient {

    val client = Client()
    val log by LoggerDelegate()

    companion object {
        /**
         * Time in milliseconds to try connecting to the server
         */
        const val CONNECTION_TIMEOUT = 5000
    }

    init {
        log.info("WogueClient starting up...")
        
        client.start()
        client.connect(
                CONNECTION_TIMEOUT,
                Network.ADDRESS,
                Network.TCP_PORT,
                Network.UDP_PORT
        )
        0
        client.addListener(object : Listener() { // TODO pull this out
            override fun received(connection: Connection?, message: Any?) {
                log.info("Message received from server! Message: {}", message)
            }
        })
    
        log.info("WogueClient started successfully!")
        
    }
}