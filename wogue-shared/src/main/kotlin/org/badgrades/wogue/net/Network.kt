package org.badgrades.wogue.net

import com.esotericsoftware.kryo.Kryo
import org.badgrades.wogue.model.Character

/**
 * A collection of network related utilities and variables
 */
class Network {
    companion object {

        /**
         * The TCP port to connect / listen to
         */
        const val TCP_PORT = 696969

        /**
         * The UDP port to connect / listen to
         */
        const val UDP_PORT = 797979

        /**
         * The address the server is hosted on
         */
        const val ADDRESS = "127.0.0.1"


        /**
         * https://github.com/EsotericSoftware/kryonet#registering-classes
         */
        fun register(kryo: Kryo) {

            kryo.register(Character::class.java)

        }
    }
}
