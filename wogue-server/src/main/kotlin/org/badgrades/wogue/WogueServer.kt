package org.badgrades.wogue

import com.esotericsoftware.kryonet.Connection
import com.esotericsoftware.kryonet.Listener
import com.esotericsoftware.kryonet.Server
import org.badgrades.wogue.net.Network.Companion.TCP_PORT
import org.badgrades.wogue.net.Network.Companion.UDP_PORT

class WogueServer {

    val server = Server()

    init {
        // Start and bind
        server.start()
        server.bind(
                TCP_PORT,
                UDP_PORT
        )

        // Setup listener/s
        server.addListener(object : Listener() {
            override fun received(connection: Connection?, `object`: Any?) {

            }
        })
    }
}