package org.badgrades.wogue

import org.badgrades.wogue.net.Network
import org.badgrades.wogue.util.LoggerDelegate

class WogueClient {

    val log by LoggerDelegate()

    companion object {
        /**
         * Time in milliseconds to try connecting to the server
         */
        const val CONNECTION_TIMEOUT = 5000
    }

    init {
        log.info("WogueClient starting up...")

        log.info("WogueClient started successfully!")
        
    }
}