package org.badgrades.wogue

import com.esotericsoftware.kryonet.Client
import org.badgrades.wogue.net.Network.Companion.ADDRESS
import org.badgrades.wogue.net.Network.Companion.TCP_PORT
import org.badgrades.wogue.net.Network.Companion.UDP_PORT

class WogueClient {

    val client = Client()

    companion object {
        /**
         * Time in milliseconds to try connecting to the server
         */
        const val CONNECTION_TIMEOUT = 5000
    }

    init {
        client.start()
        client.connect(
                CONNECTION_TIMEOUT,
                ADDRESS,
                TCP_PORT,
                UDP_PORT
        )
    }
}