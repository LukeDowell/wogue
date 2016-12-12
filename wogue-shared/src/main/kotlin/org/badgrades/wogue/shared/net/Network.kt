package org.badgrades.wogue.shared.net

import org.badgrades.wogue.shared.model.Character

/**
 * A collection of network related utilities and variables
 */
class Network {
    companion object {

        /**
         * The TCP port to connect / listen to
         */
        const val TCP_PORT = 6969

        /**
         * The UDP port to connect / listen to
         */
        const val UDP_PORT = 7979

        /**
         * The address the server is hosted on
         */
        const val ADDRESS = "127.0.0.1"
    }
}
